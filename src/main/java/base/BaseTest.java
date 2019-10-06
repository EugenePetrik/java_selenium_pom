package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected Logger log;

    protected String testSuiteName;
    protected String testName;
    protected String testMethodName;

    @Parameters({ "browser" })
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method, @Optional("chrome") String browser, ITestContext context) {
        String testName = context.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);

        BrowserDriverFactory factory = new BrowserDriverFactory(browser, log);
        driver = factory.createDriver();

        driver.manage().window().maximize();
        // driver.manage().window().fullscreen();
        // driver.manage().window().setSize(new Dimension(375, 812));

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        this.testSuiteName = context.getSuite().getName();
        this.testName = testName;
        this.testMethodName = context.getName();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Close browser");

        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
            driver = null;
        }
    }
}
