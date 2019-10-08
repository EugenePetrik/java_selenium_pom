package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage extends BasePageObject {

    private By dropdownLocator = By.id("dropdown");

    public DropdownPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * This method selects given option by value from dropdown
     */
    public void selectOptionByValue(int value) {
        log.info("Selecting option with value " + value + " from dropdown");
        findDropDownElement().selectByValue("" + value);
    }

    /**
     * This method selects given option by index from dropdown
     */
    public void selectOptionByIndex(int index) {
        log.info("Selecting option with index '" + index + "' from dropdown");
        findDropDownElement().selectByIndex(index);
    }

    /**
     * This method selects given option by text from dropdown
     */
    public void selectOptionByText(String option) {
        log.info("Selecting option '" + option + "' from dropdown");
        findDropDownElement().selectByVisibleText(option);
    }

    /**
     * This method returns selected option in dropdown as a string
     */
    public String getSelectedOption() {
        String selectedOption = findDropDownElement().getFirstSelectedOption().getText();
        log.info(selectedOption + " is selected in dropdown");
        return selectedOption;
    }

    /**
     * This method returns ALL selected options in dropdown as a string
     */
    public List<String> getSelectedOptions() {
        List<WebElement> selectedElements = findDropDownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    /**
     * Find DropDown Element
     */
    private Select findDropDownElement() {
        WebElement dropdownElement = find(dropdownLocator);
        return new Select(dropdownElement);
    }
}
