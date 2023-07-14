package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.ContactUs;
import utils.Utils;

public class TestClass {

    String baseUrl = System.getProperty("baseUrl");
    WebDriver driver;

    ContactUs contactus = new ContactUs();
    Utils utils = new Utils();

    @BeforeSuite
    public void setupEnvironment() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("macChromeDriver"));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
    }

    @BeforeMethod
    public void setUp() {
        driver.get(baseUrl);
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void invalidEmailWithoutDomain() {
        contactus.fillEmail(driver, "testemail");      
        contactus.submitForm(driver);
        contactus.validateErrorMessage(driver, "Invalid email address");
    }

    @Test
    public void invalidEmailIdWithoutContextPostATTheRateSymbol() {
    	contactus.fillEmail(driver, "testemail@");      
        contactus.submitForm(driver);
        contactus.validateErrorMessage(driver, "Invalid email address");
    }

    @Test
    public void invalidEmailIdWithSomeSpecialCharacters() {
    	contactus.fillEmail(driver, "testemail@sdj%^&**@gmail.com");      
        contactus.submitForm(driver);
        contactus.validateErrorMessage(driver, "Invalid email address");
    }


    @Test
    public void validEmailIdWithLocalAndDomainSections() {
    	contactus.fillFirstName(driver, "First Name");
    	contactus.fillLastName(driver, "Last Name");
    	contactus.fillEmail(driver, "testemail@gmail.com");  
    	contactus.fillComments(driver, "Comments Added");
        contactus.submitForm(driver);
        contactus.validateFormSubmittedSuccessfully(driver);
    }

    @Test
    public void validEmailIdWithAllowedSpecialCharacters() {
    	contactus.fillFirstName(driver, "First Name - Allowed Characters");
    	contactus.fillLastName(driver, "Last Name");
    	contactus.fillEmail(driver, "testemail_check@gmail.com");  
    	contactus.fillComments(driver, "Comments Added Allowed");
        contactus.submitForm(driver);
        contactus.validateFormSubmittedSuccessfully(driver);
    }

}
