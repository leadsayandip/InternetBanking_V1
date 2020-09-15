package com.InternetBanking_V1.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.InternetBanking_V1.pageObjects.AddCustomerPage;
import com.InternetBanking_V1.pageObjects.LoginPage;

public class TC_AddCustomerTest_001 extends BaseClass {

	@Test
	public void addCustomerTest() throws Exception {

		LoginPage lp = new LoginPage(driver);
		lp.setUsername(userName);
		logger.info("Userid given");
		lp.setPassword(password);
		logger.info("Password given");
		lp.clickLogin();
		logger.info("Login Successful");

		AddCustomerPage cp = new AddCustomerPage(driver);
		cp.clickAddCustomer();
		logger.info("Customer details is provided...");
		cp.txtCustomerName("Deb");
		logger.info("name given");
		cp.customerGender("female");
		logger.info("gender given");
		Thread.sleep(3000);
		cp.customerDOB("11", "11", "1994");
		logger.info("Date of Birth given");
		cp.customerAddress("Newtown");
		logger.info("address given");
		cp.customerCity("Kolkata");
		logger.info("City given");
		cp.customerState("WBP");
		logger.info("State given");
		cp.customerPin("720115");
		logger.info("pincode given");
		String moblieNumber = "7" + randomNumber();
		cp.customerMobileNo(moblieNumber);
		logger.info("mobile number given");
		String email = randomString() + "@yahoo.com";
		cp.customerEmail(email);
		logger.info("email id given");
		String pwd = randompassword();
		cp.customerPass(pwd);
		logger.info("password given");
		cp.clickSubmit();

		logger.info("Validation started");
		Thread.sleep(3000);
		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (result == true) {
			logger.info("Customer add test passed..");
			Assert.assertTrue(true);
		} else {
			logger.warn("customer add test failed..");
			captureScreen(driver, "addCustomerTest");
			logger.info("Screenshot taken");
			Assert.assertTrue(false);
		}
	}
}
