package com.InternetBanking_V1.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.InternetBanking_V1.pageObjects.DepositAmountPage;

public class TC_DepositAmountTest_001 extends BaseClass {

	public String amountdepositAccID = readConfig.depositAcc();

	@Test
	public void depositAmountTestwithValidID() throws Exception {
		DepositAmountPage dp = new DepositAmountPage(driver);

		dp.depositAmount();
		logger.info("deposit tag opened");
		dp.depositAccount(amountdepositAccID);
		logger.info("account ID is given");
		dp.amountDeposit("1000");
		logger.info("amount given");
		dp.depoDescription("Amount Received");
		logger.info("description given");
		dp.clicktoDeposit();

		logger.info("depositAmountTest with ValidID is validating");
		boolean res = driver.getPageSource()
				.contains("Transaction details of Deposit for Account " + amountdepositAccID);
		if (res == true) {
			logger.info("depositAmountTest with ValidID is passed");
			Assert.assertTrue(true);
		} else {
			logger.warn("depositAmount with ValidID test is failed");
			captureScreen(driver, "depositAmountTestwithValidID");
			logger.info("Screenshot taken");
			Assert.assertTrue(false);
		}
	}

	@Test
	public void depositAmountTestwithWrongID() throws Exception {
		DepositAmountPage dp = new DepositAmountPage(driver);

		dp.depositAmount();
		logger.info("deposit tag opened");
		dp.depositAccount("1234");
		logger.info("invalid account ID is given");
		dp.amountDeposit("1000");
		logger.info("amount given");
		dp.depoDescription("Amount Received");
		logger.info("description given");
		dp.clicktoDeposit();

		logger.info("depositAmountTest with InvalidID is validating");
		boolean res = driver.switchTo().alert().getText().contains("Account does not exist");
		if (res == true) {
			logger.info("depositAmountTest with invalid ID is passed");
			driver.switchTo().alert().accept();
			Assert.assertTrue(true);
		} else {
			logger.warn("depositAmount with Invalid ID Test is failed");
			captureScreen(driver, "depositAmountTestwithWrongID");
			logger.info("Screenshot taken");
			Assert.assertTrue(false);
		}
	}
}
