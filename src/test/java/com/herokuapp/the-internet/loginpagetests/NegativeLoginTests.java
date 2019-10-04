package loginpagetests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

public class NegativeLoginTests {

    WebDriver driver;

    @Parameters({ "browser" })
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        // Create driver
        System.out.println("Create driver " + browser);

        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Do not how to start: " + browser + ", set up Chrome browser");
                driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
    }

    @Parameters({ "username", "password", "expectedErrorMessage" })
    @Test(priority = 1)
    public void negativeLoginTest(String username, String password, String expectedErrorMessage) {
        System.out.println("Start Negative Login Test");

        // Open Main page
        String url = "https://the-internet.herokuapp.com";
        driver.get(url);
        System.out.println("Main page is opened");

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

    @AfterMethod
    public void tearDown() {
        System.out.println("Close browser");
        driver.quit();
    }
}
