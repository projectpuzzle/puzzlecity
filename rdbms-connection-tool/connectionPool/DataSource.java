package connectionPool;

import java.sql.Connection;

public class DataSource {
	public static JDBCConnectionPool jDBCConnectionPool = new JDBCConnectionPool();

	public static void fill(String driver, String url, String user, String password) {
		jDBCConnectionPool.fill(driver, url, user, password);
	}

	public static Connection getConnectionByUrl(String connectionurl) {
		return jDBCConnectionPool.getConnectionByUrl(connectionurl);
	}

	public static void replace(Connection c) {
		jDBCConnectionPool.replace(c);
	}

	public static void closeAllConnections() {
		jDBCConnectionPool.closeAllConnections();
	}

}
