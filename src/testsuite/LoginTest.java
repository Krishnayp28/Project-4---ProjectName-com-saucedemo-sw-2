package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/ ";
    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        // Find the username field element
        WebElement usernameField = driver.findElement(By.id("user-name"));
        // Type the username to username field element
        usernameField.sendKeys("standard_user");
        //Find the password field element and sent password on password field
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // Find the login button element and click
        WebElement loginButton = driver.findElement(By.xpath("//input[@name ='login-button']"));
        loginButton.click();
        String expectedMessage ="PRODUCTS";// expected text from requirement
        String actualTextElement = driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText().toUpperCase();
        Assert.assertEquals("user was not able to login successfully ",expectedMessage,actualTextElement);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        // Find the username field element
        WebElement usernameField = driver.findElement(By.id("user-name"));
        // Type the username to username field element
        usernameField.sendKeys("standard_user");
        //Find the password field element and sent password on password field
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // Find the login button element and click
        WebElement loginButton = driver.findElement(By.xpath("//input[@name ='login-button']"));
        loginButton.click();
        int expectedNumberOfProducts = 6;// as per Requirement
        int actualNumberOfProducts = driver.findElements(By.className("inventory_item")).size();
        Assert.assertEquals("Different number products are displayed on the page",expectedNumberOfProducts,actualNumberOfProducts);



    }
    @After
    public void close(){
        closeBrowser();
    }


}
