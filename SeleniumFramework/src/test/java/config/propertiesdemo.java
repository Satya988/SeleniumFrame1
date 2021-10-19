package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import tests.GoogleSearchTest2;

public class propertiesdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void getProperties() throws IOException
	{
		Properties prop=new Properties();
		InputStream input=new FileInputStream("C:\\Users\\shrik\\eclipse-workspace\\SeleniumFramework\\src\\test\\java\\config\\config.properties");
		prop.load(input);
		String brow=prop.getProperty("browser");
		GoogleSearchTest2.BrowserName=brow;
		
		
	}
	}
