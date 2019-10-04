package loginpagetests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PositiveLoginTests extends BaseTest {

    @Test
    public void positiveLoginTest() {
        System.out.println("Start Positive Login Test");

        // Open Main page
        String url = "https://the-internet.herokuapp.com";
        driver.get(url);
        System.out.println("Main page is opened");

        // Click on Form Authentication link
        driver.findElement(By.linkText("Form Authentication")).click();

        // Enter Username and Password
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        WebDriverWait wait = new WebDriverWait(driver,10);

        // Push Login button
        WebElement loginButton = driver.findElement(By.className("radius"));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();

        // Verification
        // New url
        String expectedUrl = "https://the-internet.herokuapp.com/secure";
        assertEquals(driver.getCurrentUrl(), expectedUrl);

        // Log out button is visible
        assertTrue(driver.findElement(By.cssSelector("a[href='/logout']")).isDisplayed(),
                "Log out button is not visible");

        // Successful log in message
        String expectedSuccessMessage = "You logged into a secure area!";
        String actualSuccessMessage = driver.findElement(By.id("flash")).getText();
        assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
                "actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
                        + expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
    }
}
