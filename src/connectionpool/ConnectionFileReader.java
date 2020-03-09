package connectionpool;

public final class ConnectionFileReader {

	private String driver;
	private String url;
	private String user;
	private String password;

	public ConnectionFileReader() {
		super();
	}

	public ConnectionFileReader(String driver, String url, String user, String password) {
		super();
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password = password;

	}

}