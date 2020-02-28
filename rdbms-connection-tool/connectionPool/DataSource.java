package connectionPool;

import java.sql.Connection;

public class DataSource {
	public static JDBCConnectionPool jDBCConnectionPool = new JDBCConnectionPool();

	public static Connection getConnectionByUrl(String connectionurl) {
		return jDBCConnectionPool.getConnectionByUrl(connectionurl);	
	}

	public void replace(Connection c) {
		jDBCConnectionPool.replace(c);
	}

	public void closeAllConnections() {
		jDBCConnectionPool.closeAllConnections();
	}

}
