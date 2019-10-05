package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage extends BasePageObject {

    private String linkXpath_Format = "//a[contains(text(), '%s')]";
    private By link_Example1 = By.xpath(String.format(linkXpath_Format, "Example 1"));
    private By link_Example2 = By.xpath(String.format(linkXpath_Format, "Example 2"));

    public DynamicLoadingPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Open DynamicLoadingExample1Page
     */
    public DynamicLoadingExample1Page clickExample1() {
        click(link_Example1);
        return new DynamicLoadingExample1Page(driver, log);
    }

    /**
     * Open DynamicLoadingExample2Page
     */
    public DynamicLoadingExample2Page clickExample2() {
        click(link_Example2);
        return new DynamicLoadingExample2Page(driver, log);
    }

    /**
     * Right click on example2 link
     */
    public DynamicLoadingExample2Page rightClickOnExample2Link() {
        driver.findElement(link_Example2).sendKeys(Keys.CONTROL, Keys.RETURN);
        return new DynamicLoadingExample2Page(driver, log);
    }
}
