package com.InternetBanking_V1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[2]/a")
	WebElement addCustomer;

	@CacheLookup
	@FindBy(name = "name")
	WebElement customerName;

	@CacheLookup
	@FindBy(name = "rad1")
	WebElement gender;

	@CacheLookup
	@FindBy(id = "dob")
	WebElement dateOfBirth;

	@CacheLookup
	@FindBy(name = "addr")
	WebElement address;

	@CacheLookup
	@FindBy(name = "city")
	WebElement city;

	@CacheLookup
	@FindBy(name = "state")
	WebElement state;

	@CacheLookup
	@FindBy(name = "pinno")
	WebElement pincode;

	@CacheLookup
	@FindBy(name = "telephoneno")
	WebElement mobileNo;

	@CacheLookup
	@FindBy(name = "emailid")
	WebElement emailid;

	@CacheLookup
	@FindBy(name = "password")
	WebElement password;

	@CacheLookup
	@FindBy(name = "sub")
	WebElement btnSubmit;

	public void clickAddCustomer() {
		addCustomer.click();
	}

	public void txtCustomerName(String cName) {
		customerName.sendKeys(cName);
	}

	public void customerGender(String cGender) {
		gender.sendKeys(cGender);
	}

	public void customerDOB(String dd, String mm, String yy) {
		dateOfBirth.sendKeys(dd);
		dateOfBirth.sendKeys(mm);
		dateOfBirth.sendKeys(yy);
	}

	public void customerAddress(String adrs) {
		address.sendKeys(adrs);
	}

	public void customerCity(String cityName) {
		city.sendKeys(cityName);
	}

	public void customerState(String stateName) {
		state.sendKeys(stateName);
	}

	public void customerPin(String pin) {
		pincode.sendKeys(pin);
	}

	public void customerMobileNo(String mobile) {
		mobileNo.sendKeys(mobile);
	}

	public void customerEmail(String email) {
		emailid.sendKeys(email);
	}

	public void customerPass(String pwd) {
		password.sendKeys(pwd);
	}

	public void clickSubmit() {
		btnSubmit.click();
	}

}
