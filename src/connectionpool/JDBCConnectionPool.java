package connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class JDBCConnectionPool {
	Collection<Connection> connections = new ArrayList<Connection>();

	public void fill(String driver, String url, String user, String password) {
		try {
			Class.forName(driver);

			Connection c = DriverManager.getConnection(url, user, password);

			connections.add(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnectionByUrl(String url) {
		for (Connection c : connections) {
			String connectionurl;
			try {
				connectionurl = c.getMetaData().getURL();
				if (connectionurl.equals(url)) {
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