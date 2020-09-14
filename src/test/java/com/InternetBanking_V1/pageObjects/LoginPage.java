package com.InternetBanking_V1.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "uid")
	@CacheLookup
	WebElement txtUsername;
	@FindBy(name = "password")
	@CacheLookup
	WebElement txtPassword;
	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement btnLogin;
	@FindBy(name = "btnReset")
	@CacheLookup
	WebElement btnReset;
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement btnLogout;
	

	public void setUsername(String userName) {
		txtUsername.sendKeys(userName);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void clickLogin() {
		btnLogin.sendKeys(Keys.ENTER);
	}

	public void clickReset() {
		btnReset.sendKeys(Keys.ENTER);
	}
	public void clickLogout() {
		btnLogout.sendKeys(Keys.ENTER);
	}
}
