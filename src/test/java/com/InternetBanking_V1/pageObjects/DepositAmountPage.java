package com.InternetBanking_V1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DepositAmountPage {

	WebDriver driver;

	public DepositAmountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[8]/a")
	WebElement clickDeposit;

	@CacheLookup
	@FindBy(name = "accountno")
	WebElement accountIdtoDeposit;

	@CacheLookup
	@FindBy(name = "ammount")
	WebElement amounttoDeposit;

	@CacheLookup
	@FindBy(name = "desc")
	WebElement depoDescription;

	@CacheLookup
	@FindBy(name = "AccSubmit")
	WebElement clickSubmit;

	public void depositAmount() {
		clickDeposit.click();
	}

	public void depositAccount(String accid) {
		accountIdtoDeposit.sendKeys(accid);
	}

	public void amountDeposit(String amnt) {
		amounttoDeposit.sendKeys(amnt);
	}

	public void depoDescription(String desc) {
		depoDescription.sendKeys(desc);
	}

	public void clicktoDeposit() {
		clickSubmit.click();
	}

}
