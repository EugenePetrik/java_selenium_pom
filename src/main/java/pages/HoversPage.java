package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HoversPage extends BasePageObject {

    private By avatarLocator = By.className("figure");
    private By viewProfileLinkLocator = By.xpath(".//a[normalize-space()='View profile']");
    private By boxCaptionLocator = By.className("figcaption");

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

    /**
     * @param index starts at 1
     */
    public FigureCaption hoverOverFigure(int index) {
        WebElement figure = findAll(avatarLocator).get(index - 1);
        hoverOverElement(figure);
        return new FigureCaption(figure.findElement(boxCaptionLocator));
    }

    public static class FigureCaption {

        private WebElement caption;
        private By headerLocator = By.tagName("h5");
        private By linkLocator = By.tagName("a");

        public FigureCaption(WebElement caption) {
            this.caption = caption;
        }

        public boolean isCaptionDisplayed() {
            return caption.isDisplayed();
        }

        public String getTitle() {
            return caption.findElement(headerLocator).getText();
        }

        public String getLink() {
            return caption.findElement(linkLocator).getAttribute("href");
        }

        public String getLinkText() {
            return caption.findElement(linkLocator).getText();
        }
    }
}
