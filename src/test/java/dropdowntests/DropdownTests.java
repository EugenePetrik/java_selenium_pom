package dropdowntests;

import base.TestUtilities;
import org.testng.annotations.Test;
import pages.DropdownPage;
import pages.WelcomePage;

import java.util.List;

import static org.testng.Assert.*;

public class DropdownTests extends TestUtilities {

    @Test(groups = "smokeTests")
    public void optionOneTest() {
        // Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on Dropdown link
        DropdownPage dropdownPage = welcomePage.clickDropdownLink();

        // Select Option 1
        String option = "Option 1";
        dropdownPage.selectOptionByText(option);

        // Verify that Option 1 is selected
        List<String> selectedOptions = dropdownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "Option not selected");
    }

    @Test(groups = "smokeTests")
    public void optionTwoTest() {
        // Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on Dropdown link
        DropdownPage dropdownPage = welcomePage.clickDropdownLink();

        // Select Option 2
        dropdownPage.selectOptionByValue(2);

        // Verify that Option 2 is selected
        String selectedOption = dropdownPage.getSelectedOption();
        assertTrue(selectedOption.equals("Option 2"),
                "Option 2 is not selected. Instead selected - " + selectedOption);
    }
}
