package waitstests;

import base.TestUtilities;
import org.testng.annotations.Test;
import pages.DynamicLoadingExample1Page;
import pages.DynamicLoadingExample2Page;
import pages.DynamicLoadingPage;
import pages.WelcomePage;

import static org.testng.Assert.*;

public class WaitTests extends TestUtilities {

    @Test(groups = { "smokeTests" })
    public void waitUntilHiddenTest() {
        // Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on Dynamic Loading Link
        DynamicLoadingPage dynamicLoadingPage = welcomePage.clickDynamicLoadingLink();

        // Click on DynamicLoadingExample1Page Link
        DynamicLoadingExample1Page dynamicLoadingExample1Page = dynamicLoadingPage.clickExample1();

        // Click on Start button
        dynamicLoadingExample1Page.clickStart();

        // Verifications
        assertEquals(dynamicLoadingExample1Page.getLoadedText(), "Hello World!",
                "Loaded text incorrect");
    }

    @Test(groups = { "smokeTests" })
    public void waitUntilVisibleTest(){
        // Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on Dynamic Loading Link
        DynamicLoadingPage dynamicLoadingPage = welcomePage.clickDynamicLoadingLink();

        // Click on DynamicLoadingExample1Page Link
        DynamicLoadingExample2Page dynamicLoadingExample2Page = dynamicLoadingPage.clickExample2();

        // Click on Start button
        dynamicLoadingExample2Page.clickStart();

        // Verifications
        assertEquals(dynamicLoadingExample2Page.getLoadedText(), "Hello World!",
                "Loaded text incorrect");
        assertFalse(dynamicLoadingExample2Page.isStartButtonDisplayed(), "Start button is displayed");
    }
}
