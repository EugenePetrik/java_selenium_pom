package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage extends BasePageObject {

    private By boxLocator = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void rightClickInBox() {
        log.info("Perform right mouse click in box");
        Actions action = new Actions(driver);
        action.contextClick(find(boxLocator)).perform();
    }

    public String getPopUpText() {
        return switchToAlert().getText();
    }

    public void acceptPopUp(){
        switchToAlert().accept();
    }
}
