package connectionPool;

public final class ConnectionFileReader {

	private String driver;
	private String connectionUrl;
	private String user;
	private String password;

	public ConnectionFileReader() {
		super();
	}

	public ConnectionFileReader(String driver, String connectionUrl, String user, String password) {
		super();
		this.driver = driver;
		this.connectionUrl = connectionUrl;
		this.user = user;
		this.password = password;

	}

}