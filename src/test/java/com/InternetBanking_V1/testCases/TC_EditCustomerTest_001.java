package com.InternetBanking_V1.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.InternetBanking_V1.pageObjects.AddCustomerPage;
import com.InternetBanking_V1.pageObjects.EditCustomerPage;
import com.InternetBanking_V1.pageObjects.LoginPage;

public class TC_EditCustomerTest_001 extends BaseClass {

	public String customerIdcode = readConfig.getCustomerId();
	
	@Test
	public void editCustomerTest() throws Exception {
		LoginPage lp = new LoginPage(driver);
		AddCustomerPage addCust = new AddCustomerPage(driver);
		EditCustomerPage editCust = new EditCustomerPage(driver);

		lp.setUsername(userName);
		logger.info("Username is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickLogin();
		logger.info("Login Successful");

		editCust.clickEditCustomer();
		logger.info("Edit Customer page is opened");
		editCust.txtCustomerId(customerIdcode);
		logger.info("Customer ID is provided");
		editCust.clickSubmit();

		logger.info("Edit Customer form is opened");
		addCust.customerAddress("JP Nagar");
		logger.info("Address changed");
		addCust.customerCity("bangalore");
		logger.info("City changed");
		addCust.customerState("KA");
		logger.info("State changed");

		String moblieNumber = "8" + randomNumber();
		addCust.customerMobileNo(moblieNumber);
		logger.info("Mobileno changed");

		String email = randomString() + "@yahoo.com";
		addCust.customerEmail(email);
		logger.info("Email id changed");

		addCust.clickSubmit();

		logger.info("Validation started");
		boolean result = driver.getPageSource().contains("Customer details updated Successfully!!!");
		if (result == true) {
			logger.info("Customer edit test passed");
			Assert.assertTrue(true);
		} else {
			driver.switchTo().alert().accept();
			logger.warn("customer edit test failed");
			captureScreen(driver, "editCustomerTest");
			logger.info("Screenshot taken");
			Assert.assertTrue(false);
		}
	}
}