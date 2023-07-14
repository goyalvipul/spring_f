package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pageObjects.ContactUs;
import utils.DataInjector;

public class TestClass {

    String baseUrl = System.getProperty("baseUrl");
    WebDriver driver;

    ContactUs contactus = new ContactUs();
    

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

    @Test(dataProvider="emailInvalidValues", dataProviderClass=DataInjector.class)
    public void invalidEmailWithoutDomain(String email) {
        contactus.fillEmail(driver, email);      
        contactus.submitForm(driver);
        contactus.validateErrorMessage(driver, "Invalid email address");
    }


    @Test(dataProvider="emailValidValues", dataProviderClass=DataInjector.class)
    public void validEmailIdWithLocalAndDomainSections(String firstname, String lastname, String email, String comment) {
    	contactus.fillFirstName(driver, firstname);
    	contactus.fillLastName(driver, lastname);
    	contactus.fillEmail(driver, email);  
    	contactus.fillComments(driver, comment);
        contactus.submitForm(driver);
        contactus.validateFormSubmittedSuccessfully(driver);
    }
    
    
    
    
//  @Test
//  public void invalidEmailIdWithoutContextPostATTheRateSymbol() {
//  	contactus.fillEmail(driver, "testemail@");      
//      contactus.submitForm(driver);
//      contactus.validateErrorMessage(driver, "Invalid email address");
//  }
//
//  @Test
//  public void invalidEmailIdWithSomeSpecialCharacters() {
//  	contactus.fillEmail(driver, "testemail@sdj%^&**@gmail.com");      
//      contactus.submitForm(driver);
//      contactus.validateErrorMessage(driver, "Invalid email address");
//  }

    
    

//    @Test
//    public void validEmailIdWithAllowedSpecialCharacters() {
//    	contactus.fillFirstName(driver, "First Name - Allowed Characters");
//    	contactus.fillLastName(driver, "Last Name");
//    	contactus.fillEmail(driver, "testemail_check@gmail.com");  
//    	contactus.fillComments(driver, "Comments Added Allowed");
//        contactus.submitForm(driver);
//        contactus.validateFormSubmittedSuccessfully(driver);
//    }

}
