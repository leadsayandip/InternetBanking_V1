package com.InternetBanking_V1.testCases;

import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.InternetBanking_V1.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readConfig = new ReadConfig();
	public String baseURL = readConfig.getBaseURL();
	public String userName = readConfig.getUsername();
	public String password = readConfig.getpassword();
	public String customerIdcode = readConfig.getCustomerId();
	public String deletecustomerIdcode = readConfig.getdeleteCustomerId();
	public static WebDriver driver;

	public static Logger logger = LogManager.getLogger(BaseClass.class);

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		if (br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			WebDriverManager.edgedriver().setup();
			driver = new InternetExplorerDriver();
		}
		logger.info(br + "Browser started Successfully");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		logger.info("URL is opened");
		driver.manage().window().maximize();
		logger.info("Browser is maximised");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		logger.info("Browser closed successfully");
	}

	public void captureScreen(WebDriver driver, String tname) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
	}

	public boolean isAlertBoxPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public String randomString(){
		String randomEmail = RandomStringUtils.randomAlphabetic(8);
		return randomEmail;
	}
	
	public String randomNumber(){
		String randomNumber = RandomStringUtils.randomNumeric(9);
		return randomNumber;
	}
	
	public String randompassword(){
		String randompwd = RandomStringUtils.randomAlphanumeric(6);
		return randompwd;
	}
}
