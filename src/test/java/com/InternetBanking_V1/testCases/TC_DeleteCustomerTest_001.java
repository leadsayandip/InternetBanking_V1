package com.InternetBanking_V1.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.InternetBanking_V1.pageObjects.DeleteCustomerPage;
import com.InternetBanking_V1.pageObjects.LoginPage;

public class TC_DeleteCustomerTest_001 extends BaseClass {
	
	public String deletecustomerIdcode = readConfig.getdeleteCustomerId();

	@Test
	public void deleteCustomerTest() throws Exception {
		LoginPage lp = new LoginPage(driver);
		DeleteCustomerPage deleteCust = new DeleteCustomerPage(driver);

		lp.setUsername(userName);
		logger.info("Username is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickLogin();
		logger.info("Login Successful");

		deleteCust.deleteCustomerbyId();
		logger.info("Delete Customer page is opened");
		deleteCust.deleteCustomer(deletecustomerIdcode);
		logger.info("Customer ID is provided");
		
		deleteCust.clicktoDelete();
		
		driver.switchTo().alert().accept();
		logger.info("alert is accepted");
		Thread.sleep(3000);
		
		if (driver.switchTo().alert().getText().contains("Customer deleted Successfully")) {
			logger.info("Customer delete test passed..");
			Assert.assertTrue(true);
		} else {
			logger.warn("customer delete test failed with warning message: "+ driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
			captureScreen(driver, "deleteCustomerTest");
			logger.info("Screenshot taken");
			Assert.assertTrue(false);
		}
	}
}
