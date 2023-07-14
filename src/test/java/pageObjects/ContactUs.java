package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ContactUs {

    public void fillFirstName(WebDriver driver, String firstName) {
        driver.findElement(By.name("first_name")).clear();
        driver.findElement(By.name("first_name")).sendKeys(firstName);
    }

    public void fillLastName(WebDriver driver, String lastName) {
        driver.findElement(By.name("last_name")).clear();
        driver.findElement(By.name("last_name")).sendKeys(lastName);
    }

    public void fillEmail(WebDriver driver, String email) {
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(email);
    }

    public void fillComments(WebDriver driver, String comments) {
        driver.findElement(By.name("message")).clear();
        driver.findElement(By.name("message")).sendKeys(comments);
    }

    public void submitForm(WebDriver driver) {
        driver.findElement(By.xpath("//div[@id='form_buttons']/input[@value='SUBMIT']")).click();
    }

    public void resetForm(WebDriver driver) {
        driver.findElement(By.xpath("//div[@id='form_buttons']/input[@value='RESET']")).click();
    }

    /**
     * This function helps to validate the error message. A single error message can
     * be passed as an argument, instead of complete string, and can be reused for
     * different validations.
     * 
     * @param driver
     * @param message
     */
    public void validateErrorMessage(WebDriver driver, String message) {
        String errorMessage = driver.findElement(By.tagName("body")).getText();
        if (errorMessage.contains(message)) {
            Assert.assertTrue(true, "\n<actual>  " + errorMessage + "  </actual> \n <expected>  " + message + "  </expected>");
        } else {
            Assert.assertTrue(false, "\n<actual>  " + errorMessage + "  </actual> \n <expected>  " + message + "  </expected>");
        }
    }

    /**
     * Using the body tag and fetching the content, as if using the ID Tag to fetch
     * specific text, it may break (element not found), if any other page opens.
     * 
     * @param driver
     */
    public void validateFormSubmittedSuccessfully(WebDriver driver) {
        String msg = driver.findElement(By.tagName("body")).getText();
        if (msg.contains("Thank You for your Message!")) {
            Assert.assertTrue(true, "Form Submitted Successfuly with Thankyou Message");
        } else {
            Assert.assertTrue(false, "Form in NOT submitted");
        }
    }

}
