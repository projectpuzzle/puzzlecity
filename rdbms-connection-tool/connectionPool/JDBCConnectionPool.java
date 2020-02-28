package connectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class JDBCConnectionPool {
	Collection<Connection> connections = new ArrayList<Connection>();

	public void remplir(String driver, String connectionurl, String user, String password) {
		try {
			Class.forName(driver);

			Connection con = DriverManager.getConnection(connectionurl, user, password);

			connections.add(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnectionByUrl(String connectionurl) {
		for (Connection connection : connections) {
			String url;
			try {
				url = connection.getMetaData().getURL();
				if (url.equals(connectionurl)) {
					return connection;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	public void remettre(Connection con) {
		connections.add(con);
	}

	public void CloseAllConnections() {
		for (Connection connection : connections) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
