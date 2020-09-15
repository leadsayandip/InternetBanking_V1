package com.InternetBanking_V1.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.InternetBanking_V1.pageObjects.LoginPage;
import com.InternetBanking_V1.pageObjects.NewAccountPage;

public class TC_AddNewAccountTest_001 extends BaseClass {
	
	public String newAccountId = readConfig.getNewAccCustomerId();
	public String amount = readConfig.depositAmount();
	public String accounttype = readConfig.accType();

	@Test
	public void addNewAccountTest() throws Exception {
		LoginPage lp = new LoginPage(driver);
		NewAccountPage ap = new NewAccountPage(driver);
		lp.setUsername(userName);
		logger.info("Userid given");
		lp.setPassword(password);
		logger.info("Password given");
		lp.clickLogin();
		logger.info("Login Successful");
		ap.accountOpen();
		logger.info("New Account page opened");
		ap.customerIdforAc(newAccountId);
		logger.info("AccountID provided");
		ap.selectAccType(accounttype);
		logger.info("Account Type is given");
		ap.initAmount(amount);
		logger.info("amount is given");
		ap.clickSubmit();
		logger.info("Validation started");

		boolean res = driver.getPageSource().contains("Account Generated Successfully!!!");
		if (res == true) {
			logger.info("New account open test is passed");
			Assert.assertTrue(true);
		} else {
			logger.warn("New Account add test is failed");
			logger.info("Screenshot taken");
			captureScreen(driver, "addNewAccountTest");
			Assert.assertTrue(false);
		}
	}
}
