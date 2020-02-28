package connectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class JDBCConnectionPool {
	Collection<Connection> connections = new ArrayList<Connection>();

	// une methode qui "remplit" l'attribut avec un certain nombre d'instances de la
	// classe Connection

	// un certain nombre de Connections??? liste? tableau?
	// driver?

	public void fill(String driver, String url, String username, String password) {
		try {
			Class.forName(driver);

			Connection c = DriverManager.getConnection(url, username, password);

			connections.add(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnectionByUrl(String connectionurl) {
		for (Connection c : connections) {
			String url;
			try {
				url = c.getMetaData().getURL();
				if (url.equals(connectionurl)) {
					return c;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void replace(Connection c) {
		for (Connection c1 : connections) {
			if (c1 == c)
				return;
		}
		connections.add(c);
	}
// test //
	public void closeAllConnections() {
		for (Connection c : connections) {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}