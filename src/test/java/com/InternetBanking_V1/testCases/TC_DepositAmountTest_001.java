package com.InternetBanking_V1.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.InternetBanking_V1.pageObjects.DepositAmountPage;

public class TC_DepositAmountTest_001 extends BaseClass {

	public String amountdepositAccID = readConfig.depositAcc();

	@Test
	public void depositAmountTest() throws Exception {
		DepositAmountPage dp = new DepositAmountPage(driver);

		dp.depositAmount();
		dp.depositAccount(amountdepositAccID);
		dp.amountDeposit("1000");
		dp.depoDescription("Amount Received");
		dp.clicktoDeposit();

		boolean res = driver.getPageSource()
				.contains("Transaction details of Deposit for Account " + amountdepositAccID);
		if (res == true) {
			Assert.assertTrue(true);
		} else {
			captureScreen(driver, "depositAmountTest");
			Assert.assertTrue(false);
		}
	}

	@Test
	public void depositAmountTestwithWrongID() throws Exception {
		DepositAmountPage dp = new DepositAmountPage(driver);

		dp.depositAmount();
		dp.depositAccount("1234");
		dp.amountDeposit("1000");
		dp.depoDescription("Amount Received");
		dp.clicktoDeposit();

		boolean res = driver.switchTo().alert().getText().contains("Account does not exist");
		if (res == true) {
			driver.switchTo().alert().accept();
			Assert.assertTrue(true);
		} else {
			captureScreen(driver, "depositAmountTestwithWrongID");
			Assert.assertTrue(false);
		}
	}
}
