package com.InternetBanking_V1.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;

	public ReadConfig() {
		try {
			FileInputStream file = new FileInputStream("./Configuration/config.properties");
			prop = new Properties();
			prop.load(file);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public String getBaseURL() {
		String url = prop.getProperty("baseURL");
		return url;
	}

	public String getUsername() {
		String uname = prop.getProperty("userName");
		return uname;
	}

	public String getpassword() {
		String pwd = prop.getProperty("password");
		return pwd;
	}

	public String getCustomerId() {
		String custId = prop.getProperty("customerIdcode");
		return custId;
	}

	public String getdeleteCustomerId() {
		String custId = prop.getProperty("deletecustomerIdcode");
		return custId;
	}
}
