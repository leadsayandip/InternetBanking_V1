package com.InternetBanking_V1.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.InternetBanking_V1.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void LoginTest() throws Exception {

		LoginPage lp = new LoginPage(driver);

		// if (driver.getTitle().equals("Guru99 Bank Home Page")) {
		// logger.info("Index page title is checked");
		// Assert.assertTrue(true);
		// } else {
		// logger.warn("Login Test is failed");
		// captureScreen(driver, "LoginTest");
		// logger.info("Screenshot taken");
		// Assert.assertTrue(false);
		// }
		
		lp.setUsername(userName);
		logger.info("Username is entered");

		lp.setPassword(password);
		logger.info("Password is entered");

		lp.clickLogin();
		Thread.sleep(3000);
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Home Page title is checked");
			logger.info("Login test is passed");
		} else {
			logger.warn("Login Test is failed");
			captureScreen(driver, "LoginTest");
			logger.info("Screenshot taken");
			Assert.assertTrue(false);
		}

		// lp.clickLogout();
		// logger.info("Logout successfully");
		// driver.switchTo().alert().accept();
		// driver.switchTo().defaultContent();
	}
}
