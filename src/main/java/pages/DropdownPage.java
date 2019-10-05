package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage extends BasePageObject {

    private By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * This method selects given option by value from dropdown
     */
    public void selectOptionByValue(int i) {
        log.info("Selecting option " + i + " from dropdown");

        findDropDownElement().selectByValue("" + i);

        // There are three ways to use Select class:

        // #1
        // findDropDownElement().selectByIndex(i);

        // #2
        // findDropDownElement().selectByValue("" + i);

        // #3
        // findDropDownElement().selectByVisibleText("Option " + i);
    }

    /**
     * This method selects given option by value from dropdown
     */
    public void selectOptionByText(String option) {
        log.info("Selecting option '" + option + "' from dropdown");

        findDropDownElement().selectByVisibleText(option);
    }

    /**
     * This method returns selected option in dropdown as a string
     */
    public String getSelectedOption() {
        WebElement dropdownElement = find(dropdown);
        Select dropdown = new Select(dropdownElement);
        String selectedOption = dropdown.getFirstSelectedOption().getText();
        log.info(selectedOption + " is selected in dropdown");
        return selectedOption;
    }

    /**
     * This method returns ALL selected options in dropdown as a string
     */
    public List<String> getSelectedOptions() {
        List<WebElement> selectedElements = findDropDownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    /**
     * Find DropDown Element
     */
    private Select findDropDownElement() {
        WebElement dropdownElement = find(dropdown);
        return new Select(dropdownElement);
    }
}
