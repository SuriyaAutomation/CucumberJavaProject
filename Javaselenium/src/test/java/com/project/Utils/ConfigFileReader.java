package com.project.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class ConfigFileReader {
	private Properties properties;
	private final String propertyfilepath ="src\\test\\resources\\config\\config.properties";
	
	public ConfigFileReader() {
		BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyfilepath));
            properties = new Properties();
            try {
				properties.load(reader);
				reader.close();
			} catch (Throwable e) {
				e.printStackTrace();
			}
            
		} catch (Throwable e) {
			e.printStackTrace();
			throw new RuntimeException("config.properties not found _ "+propertyfilepath);
		}

	}
	
	public String getApplicationUrl(String eType) {
		String url = properties.getProperty("url"+eType);
		if (url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public String Getusername() {
		String username = properties.getProperty("username");
		if (username!=null) return username;
		else throw new RuntimeException("username not specified in the Configuration.properties file.");

	}
	
	public String Getpassword() {
		String password = properties.getProperty("password");
		if (password!=null) return password;
		else throw new RuntimeException("password not specified in the Configuration.properties file.");

	}
	
	public String GetenvironmentDetails() {
		String environment = properties.getProperty("environment");
		if (environment!=null) return environment;
		else throw new RuntimeException("environment not specified in the Configuration.properties file.");

	}



}

