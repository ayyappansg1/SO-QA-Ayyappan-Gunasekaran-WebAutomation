package pages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.github.javafaker.Faker;

import helper.LocalHelper;

public class HomePage extends LocalHelper{
	private static final Logger logger = LogManager.getLogger(HomePage.class);
	//private volatile static HomePage instance;
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(css = "#user-name")
	private WebElement usernameBox;
	@FindBy(css= "#password")
	private WebElement passwordBox;
	@FindBy(css = "#login-button")
	private WebElement loginButton;
	private By allProducts = By.xpath("//div[@class='inventory_item_name ']");
	@FindBy(css = ".shopping_cart_link")
	private WebElement cartButton;
	@FindBy(css = "#checkout")
	private WebElement checkoutButton;
	@FindBy(css = "#first-name")
	private WebElement firstnameBox;
	@FindBy(css = "#last-name")
	private WebElement lastnameBox;
	@FindBy(css = "#postal-code")
	private WebElement postalCode;
	@FindBy(css = "#continue")
	private WebElement continueButton;
	@FindBy(css = "#finish")
	private WebElement finishButton;
	@FindBy(xpath = "//h2[text()='Thank you for your order!']")
	private WebElement successMessage;
	@FindBy(xpath = "//*[contains(text(),'Sorry, this user has been locked out.')]")
	private WebElement errorMessageLogin;


	public void sendUsername(String username) {
		logger.info("Send Username");
		sendValue(usernameBox, driver, username);
		logger.info("Username passed");
	}

	public void sendPassword(String password) {
		logger.info("Send Password");
		sendValue(passwordBox, driver, password);
		logger.info("Password passed");
	}

	public void clickLoginButton() {
		logger.info("Click Login Button");
		clickElement(loginButton, driver);
	}

	public void selectParticularProduct(String expectedProduct) {
		logger.info("Trying to Select Particular Product");
		selectParticularProductAndClickPriceButton(allProducts,driver,expectedProduct);
		logger.info("Element Clicked SuccessFully");
	}

	public void clickCartButton() {
		logger.info("Trying to Click BCart Button");
		clickElement(cartButton, driver);
	}
	public void clickCheckoutButton() {
		logger.info("Trying to Click Checkout Button");
		clickElement(checkoutButton, driver);
	}
	public void fillDetails() {
		logger.info("Trying to Click Checkout Button");
		sendValue(firstnameBox, driver,new Faker().name().firstName());
		sendValue(lastnameBox, driver,new Faker().name().lastName());
		sendValue(postalCode, driver,new Faker().address().zipCode());
	}
	public void clickContinueButton() {
		logger.info("Trying to Click Contiune Button");
		clickElement(continueButton, driver);
	}
	public void clickFinishButton() {
		logger.info("Trying to Click Finish Button");
		clickElement(finishButton, driver);
	}
	public boolean checkSuccessMessage(String successMessagetext) {
		logger.info("Fetch Text from success message");
		return getTextContent(successMessage,driver).contains(successMessagetext);
	}

	public boolean checkErrorMessageDuringLogin() {
		logger.info("Trying to Enter the Locked username and password");
		return getTextContent(errorMessageLogin,driver).contains("Sorry, this user has been locked out.");
	}



}
