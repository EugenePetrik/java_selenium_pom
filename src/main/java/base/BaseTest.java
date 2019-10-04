package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    @Parameters({ "browser" })
    @BeforeMethod(alwaysRun = true)
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
        // driver.manage().window().fullscreen();
        // driver.manage().window().setSize(new Dimension(375, 812));

        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        System.out.println("Close browser");
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
