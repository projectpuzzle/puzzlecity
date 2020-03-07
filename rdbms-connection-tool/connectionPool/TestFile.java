package connectionPool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;


public class TestFile {

	public static void main(String args[]) throws FileNotFoundException, IOException {

		
		Properties props = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\etudiant\\git\\puzzlecity\\rdbms-connection-tool\\connectionPool\\ConnectionFile.xml");

	
		props.loadFromXML(fis);

		
		String user = props.getProperty("jdbc.user");
		System.out.println("jdbc.user: " + user);
		
		String password = props.getProperty("jdbc.password");
		System.out.println("jdbc.password: " + password);
		
		String url = props.getProperty("jdbc.url");
		System.out.println("jdbc.url: " + url);
		
		String driver = props.getProperty("jdbc.driver");
		System.out.println("jdbc.driver: " + driver);


		DataSource.fill(driver, url, user, password);
}

	}
	


