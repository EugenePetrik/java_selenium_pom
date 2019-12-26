package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HoversPage extends BasePageObject {

    private By avatarLocator = By.className("figure");
    private By viewProfileLinkLocator = By.xpath(".//a[normalize-space()='View profile']");

    public HoversPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Open specified user profile
     */
    public void openUserProfile(int index) {
        WebElement specifiedUserAvatar = findAll(avatarLocator).get(index - 1);
        hoverOverElement(specifiedUserAvatar);
        specifiedUserAvatar.findElement(viewProfileLinkLocator).click();
    }
}
