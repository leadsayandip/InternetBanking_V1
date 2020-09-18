package com.InternetBanking_V1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WithdrawnAmountPage {

	WebDriver driver;

	public WithdrawnAmountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[9]/a")
	WebElement clkWithdrawn;

	@CacheLookup
	@FindBy(name = "accountno")
	WebElement withdrawAccountNo;

	@CacheLookup
	@FindBy(name = "ammount")
	WebElement amounttoWithdraw;

	@CacheLookup
	@FindBy(name = "desc")
	WebElement description;

	@CacheLookup
	@FindBy(name = "AccSubmit")
	WebElement clkSubmit;

	public void withdrawOption() {
		clkWithdrawn.click();
	}

	public void withdrawAcc(String accId) {
		withdrawAccountNo.sendKeys(accId);
	}

	public void amounttoWithdrawn(String amnt) {
		amounttoWithdraw.sendKeys(amnt);
	}

	public void withdrawDesc(String desc) {
		description.sendKeys(desc);
	}

	public void btnSubmit() {
		clkSubmit.click();
	}

}
