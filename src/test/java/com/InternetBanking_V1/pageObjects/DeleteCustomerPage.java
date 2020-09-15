package com.InternetBanking_V1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage {

	WebDriver driver = null;

	public DeleteCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[4]/a")
	WebElement deleteCustomer;

	@CacheLookup
	@FindBy(name = "cusid")
	WebElement customerId;

	@CacheLookup
	@FindBy(name = "AccSubmit")
	WebElement clickSubmit;

	public void deleteCustomerbyId() {
		deleteCustomer.click();
	}

	public void deleteCustomer(String customerid) {
		customerId.sendKeys(customerid);
	}

	public void clicktoDelete() {
		clickSubmit.click();
	}
}
