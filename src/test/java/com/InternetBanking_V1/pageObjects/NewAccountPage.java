package com.InternetBanking_V1.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAccountPage {
	
	WebDriver driver;
	
	public NewAccountPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy (xpath = "/html/body/div[3]/div/ul/li[5]/a") WebElement newAccountopen;
	
	@CacheLookup
	@FindBy (name = "cusid") WebElement customerId;
	
	@CacheLookup
	@FindBy (name = "selaccount") WebElement selectAccountType;
	
	@CacheLookup
	@FindBy (name = "inideposit") WebElement depositAmount;
	
	@CacheLookup
	@FindBy (name = "button2") WebElement btnSubmit;
	
	
	public void accountOpen(){
		newAccountopen.click();
	}
	
	public void customerIdforAc(String cusId){
		customerId.sendKeys(cusId);
	}
	public void initAmount(String amnt){
		depositAmount.sendKeys(amnt);
	}
	
	public void selectAccType(String acctype){
		Select select = new Select(selectAccountType);
		select.selectByValue(acctype);
	}
	
	public void clickSubmit(){
		btnSubmit.sendKeys(Keys.ENTER);
	}
	
	
}
