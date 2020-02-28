package connectionPool;

import java.sql.Connection;

public class DataSource {
	public static JDBCConnectionPool jDBCConnectionPool = new JDBCConnectionPool();

	public void remplir(String driver, String chaineDeConnexion, String user, String password) {
		jDBCConnectionPool.remplir(driver, chaineDeConnexion, user, password);
	}

	public Connection getConnectionByUrl(String chaineDeConnexion) {
		return jDBCConnectionPool.getConnectionByUrl(chaineDeConnexion);	
		}

	public void remettre(Connection con) {
		jDBCConnectionPool.remettre(con);
	}

	public void CloseAllConnections() {
		jDBCConnectionPool.CloseAllConnections();
	}

}
