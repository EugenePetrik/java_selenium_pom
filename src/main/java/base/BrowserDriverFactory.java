package base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserDriverFactory {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private String browser;
    private Logger log;

    public BrowserDriverFactory(String browser, Logger log) {
        this.browser = browser.toLowerCase();
        this.log = log;
    }

    public WebDriver createDriver() {
        log.info("Create driver " + browser);

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "lib/chrome/chromedriver");
                driver.set(new ChromeDriver());
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", "lib/firefox/geckodriver");
                driver.set(new FirefoxDriver());
                break;

            case "chromeheadless":
                System.setProperty("webdriver.chrome.driver", "lib/chrome/chromedriver");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                driver.set(new ChromeDriver(chromeOptions));
                break;

            case "firefoxheadless":
                System.setProperty("webdriver.gecko.driver", "lib/firefox/geckodriver");
                FirefoxBinary firefoxBinary = new FirefoxBinary();
                firefoxBinary.addCommandLineOptions("--headless");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setBinary(firefoxBinary);
                driver.set(new FirefoxDriver(firefoxOptions));
                break;

            default:
                log.info("Do not know how to start:" + browser + ", starting Chrome browser by default.");
                System.setProperty("webdriver.chrome.driver", "lib/chrome/chromedriver");
                driver.set(new ChromeDriver());
        }

        return driver.get();
    }
}
