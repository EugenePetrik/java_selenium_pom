package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage extends BasePageObject {

    private By bodyLocator = By.xpath("//body");
    private By inputFieldLocator = By.id("target");
    private By resultTextLocator = By.id("result");

    public KeyPressesPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Press given key while on this page
     */
    public void pressKey(Keys key) {
        log.info("Pressing " + key.name());
        pressKey(bodyLocator, key);
    }

    /**
     * Enter text
     */
    public void enterText(String text) {
        type(text, inputFieldLocator);
    }

    /**
     * Enter PI
     */
    public void enterPi() {
        enterText(Keys.chord(Keys.ALT, "p") + "=3.14");
    }

    /**
     * Get result text
     */
    public String getResultText() {
        String result = find(resultTextLocator).getText();
        log.info("Result text: " + result);
        return result;
    }
}
