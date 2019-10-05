package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LargeAndDeepDomPage extends BasePageObject {

    private By tableLocator = By.id("large-table");

    public LargeAndDeepDomPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void scrollToTable() {
        WebElement tableElement = driver.findElement(tableLocator);
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script, tableElement);
    }
}
