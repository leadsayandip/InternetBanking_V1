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

	public String getNewAccCustomerId() {
		String custId = prop.getProperty("newAccountId");
		return custId;
	}

	public String getdeleteCustomerId() {
		String custId = prop.getProperty("deletecustomerIdcode");
		return custId;
	}

	public String depositAmount() {
		String amnt = prop.getProperty("amount");
		return amnt;
	}

	public String accType() {
		String type = prop.getProperty("accounttype");
		return type;
	}

	public String editAccNo() {
		String atype = prop.getProperty("accountNumber");
		return atype;
	}

	public String accTypeChange() {
		String ctype = prop.getProperty("accounttypechange");
		return ctype;
	}
	
	public String depositAcc(){
		String depoAcc = prop.getProperty("amountdepositAccID");
		return depoAcc;
	}
}
