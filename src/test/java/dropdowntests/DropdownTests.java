package dropdowntests;

import base.TestUtilities;
import org.testng.annotations.Test;
import pages.DropdownPage;
import pages.WelcomePage;

import java.util.List;

import static org.testng.Assert.*;

public class DropdownTests extends TestUtilities {
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
