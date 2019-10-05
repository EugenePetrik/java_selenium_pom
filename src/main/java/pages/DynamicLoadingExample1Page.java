package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingExample1Page extends BasePageObject{

    private By startButtonLocator = By.cssSelector("#start button");
    private By loadingIndicatorLocator = By.id("loading");
    private By loadedTextLocator = By.id("finish");

    public DynamicLoadingExample1Page(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Click on Start button
     */
    public void clickStart() {
        click(startButtonLocator);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicatorLocator)));
    }

    /**
     * Get loaded text
     */
    public String getLoadedText() {
        return find(loadedTextLocator).getText();
    }
}
