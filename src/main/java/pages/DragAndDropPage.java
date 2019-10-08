package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragAndDropPage extends BasePageObject {

    private By columnALocator = By.id("column-a");
    private By columnBLocator = By.id("column-b");

    public DragAndDropPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Drag A box and drop it on B box
     */
    public void dragAtoB() {
        log.info("Drag and drop A box on B box");
        performDragAndDrop(columnALocator, columnBLocator);
    }

    /**
     * Getting Column A Text
     */
    public String getColumnAText() {
        String text = find(columnALocator).getText();
        log.info("Column A Text: " + text);
        return text;
    }

    /**
     * Getting Column B Text
     */
    public String getColumnBText() {
        String text = find(columnBLocator).getText();
        log.info("Column B Text: " + text);
        return text;
    }
}
