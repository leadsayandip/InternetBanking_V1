package com.InternetBanking_V1.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.InternetBanking_V1.pageObjects.EditAccountPage;

public class TC_EditAccountTest_001 extends BaseClass {
	
	public String accountNumber = readConfig.editAccNo();
	public String accounttypechange = readConfig.accTypeChange();

	@Test
	public void editAccountTest() throws Exception{
		EditAccountPage editAcc = new EditAccountPage(driver);
		editAcc.editAccountbyaccId();
		editAcc.accountId(accountNumber);
		editAcc.btnSubmit();
		editAcc.acctypechangeto(accounttypechange);
		editAcc.editBtnSubmit();
		
		boolean res = driver.getPageSource().contains("Account details updated Successfully!!!");
		if(res == true) {
			Assert.assertTrue(true);
		}else {
			captureScreen(driver, "editAccountTest");
			Assert.assertTrue(false);
		}
	}
}
