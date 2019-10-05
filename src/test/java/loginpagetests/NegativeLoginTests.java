package loginpagetests;

import base.TestUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

public class NegativeLoginTests extends TestUtilities {

    @Parameters({ "username", "password", "expectedErrorMessage" })
    @Test(priority = 1)
    public void negativeLoginTest(String username, String password, String expectedErrorMessage) {
        log.info("Starting Negative Login Test");

        // Open Main page
        String url = "https://the-internet.herokuapp.com";
        driver.get(url);
        log.info("Main page is opened");

        // Click on Form Authentication link
        driver.findElement(By.linkText("Form Authentication")).click();

        // Enter Username and Password
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

        WebDriverWait wait = new WebDriverWait(driver,10);

        // Push Login button
        WebElement loginButton = driver.findElement(By.className("radius"));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();

        // Verification
        String actualErrorMessage = driver.findElement(By.id("flash")).getText();
        assertTrue(actualErrorMessage.contains(expectedErrorMessage),
                "actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
                        + expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage);
    }
}
