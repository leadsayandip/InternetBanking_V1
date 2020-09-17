package com.InternetBanking_V1.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.InternetBanking_V1.pageObjects.WithdrawnAmountPage;

public class TC_WithdrawAmountTest_008 extends BaseClass {

	public String amountwithdrawnID = readConfig.withdrawAcc();

	@Test
	public void withdrawAmountwithValidId() throws Exception {
		WithdrawnAmountPage wp = new WithdrawnAmountPage(driver);
		
		wp.withdrawOption();
		logger.info("withdrawn page opened");
		wp.withdrawAcc(amountwithdrawnID);
		logger.info("account id is provided");
		wp.amounttoWithdrawn("1000");
		logger.info("amount is given");
		wp.withdrawDesc("withdrawn successfully");
		logger.info("description given");
		wp.btnSubmit();
		
		logger.info("validation is started");
		boolean res = driver.getPageSource().contains("Transaction details of Withdrawal for Account "+amountwithdrawnID);
		if(res==true){
			logger.info("withdrawn test is passed");
			Assert.assertTrue(true);
		} else {
			logger.warn("withdrawn test is failed");
			captureScreen(driver, "withdrawAmountwithValidId");
			logger.info("Screenshot taken");
			Assert.assertTrue(false);
		}
	}

}
