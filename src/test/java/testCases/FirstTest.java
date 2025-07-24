package testCases;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import constants.Constants;
import driverManager.DriverManager;
import helper.LocalHelper;
import pages.HomePage;

public class FirstTest extends BaseClass {
	public HomePage homePage;
	List<String> useDevToolstoGrabAPINetworks;
	Map<String, String> tableValues;
	String downloadRandomFile;
	String clickAndUploadFile;

//	@BeforeClass
//	public void beforeClassForObjectInstantiation() throws MalformedURLException {
//	}

	@BeforeMethod
	public void launchApplication() throws MalformedURLException {
		homePage = new HomePage(getDriver());
		launchApplication(Constants.application_url);
	}

	@Parameters({"username","password"})
	@Test(priority = 0)
	public void verifyPlaceOrderEndtoEndFlow(String username,String password) {
		homePage.sendUsername(username);
		homePage.sendPassword(password);
		homePage.clickLoginButton();
		homePage.selectParticularProduct("Bolt T-Shirt");
		homePage.clickCartButton();
		homePage.clickCheckoutButton();
		homePage.fillDetails();
		homePage.clickContinueButton();
		homePage.clickFinishButton();
		Assert.assertTrue(homePage.checkSuccessMessage("Thank you for your order!"),"SuccessMessage not appear");
	}
	@Description("Negative Testing")
	@Test(priority = 1)
	public void invalidLoginScenario() {
		homePage.sendUsername("sanfjasfn");
		homePage.sendPassword("adsknasjdsanjkd");
		homePage.clickLoginButton();
		Assert.assertTrue(homePage.checkErrorMessageDuringLogin(),"Error message not appears during login");
	}


	
}
