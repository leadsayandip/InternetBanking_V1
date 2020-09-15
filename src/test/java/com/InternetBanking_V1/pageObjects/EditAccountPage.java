package com.InternetBanking_V1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditAccountPage {
	WebDriver driver;

	public EditAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[6]/a")
	WebElement editAccount;

	@CacheLookup
	@FindBy(name = "accountno")
	WebElement accountNumber;

	@CacheLookup
	@FindBy(name = "AccSubmit")
	WebElement clickSubmit;

	@CacheLookup
	@FindBy(name = "a_type")
	WebElement acctypeChange;

	@CacheLookup
	@FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[21]/td[2]/input[1]")
	WebElement editSubmit;

	public void editAccountbyaccId() {
		editAccount.click();
	}

	public void accountId(String accId) {
		accountNumber.sendKeys(accId);
	}

	public void btnSubmit() {
		clickSubmit.click();
	}

	public void acctypechangeto(String newType) {
		Select select = new Select(acctypeChange);
		select.selectByValue(newType);
	}

	public void editBtnSubmit() {
		editSubmit.click();
	}

}
