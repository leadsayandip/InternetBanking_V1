package com.InternetBanking_V1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {

	WebDriver driver;

	public EditCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[3]/a")
	WebElement editCustomer;
	
	@CacheLookup
	@FindBy(name = "cusid")
	WebElement customerID;

	@CacheLookup
	@FindBy(name = "AccSubmit")
	WebElement accSubmit;

	public void clickEditCustomer() {
		editCustomer.click();
	}

	public void txtCustomerId(String cusId) {
		customerID.sendKeys(cusId);
	}

	public void clickSubmit() {
		accSubmit.click();
	}

}
