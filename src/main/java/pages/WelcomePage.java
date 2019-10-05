package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePageObject {

    private String pageUrl = "https://the-internet.herokuapp.com/";

    private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
    private By forgotPasswordLinkLocator = By.linkText("Forgot Password");
    private By checkboxesLinkLocator = By.linkText("Checkboxes");
    private By dropdownLinkLocator = By.linkText("Dropdown");
    private By javaScriptAlertsLinkLocator = By.linkText("JavaScript Alerts");
    private By contextMenuLinkLocator = By.linkText("Context Menu");
    private By multipleWindowsLinkLocator = By.linkText("Multiple Windows");
    private By editorLinkLocator = By.linkText("WYSIWYG Editor");
    private By framesLinkLocator = By.linkText("Frames");
    private By keyPressesLocator = By.linkText("Key Presses");
    private By fileUploadLocator = By.linkText("File Upload");
    private By dragAndDropLocator = By.linkText("Drag and Drop");
    private By hoversLocator = By.linkText("Hovers");
    private By horizontalSliderLocator = By.linkText("Horizontal Slider");
    private By largeAndDeepDomLocator = By.linkText("Large & Deep DOM");
    private By infiniteScrollLocator = By.linkText("Infinite Scroll");
    private By dynamicLoadingLocator = By.linkText("Dynamic Loading");

    public WelcomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Open WelcomePage with it's url
     */
    public void openPage() {
        log.info("Opening page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Page opened!");
    }

    /**
     * Open LoginPage by clicking on Form Authentication Link
     */
    public LoginPage clickFormAuthenticationLink() {
        log.info("Clicking Form Authentication link on Welcome Page");
        click(formAuthenticationLinkLocator);
        return new LoginPage(driver, log);
    }

    /**
     * Open ForgotPasswordPage by clicking on Forgot Password Link
     */
    public ForgotPasswordPage clickForgotPasswordLink() {
        log.info("Clicking Forgot Password link on Welcome Page");
        click(forgotPasswordLinkLocator);
        return new ForgotPasswordPage(driver, log);
    }

    /**
     * Open CheckboxesPage by clicking on Checkboxes Link
     */
    public CheckboxesPage clickCheckboxesLink() {
        log.info("Clicking Checkboxes link on Welcome Page");
        click(checkboxesLinkLocator);
        return new CheckboxesPage(driver, log);
    }

    /**
     * Open DropdownPage by clicking on Dropdown Link
     */
    public DropdownPage clickDropdownLink() {
        log.info("Clicking Dropdown link on Welcome Page");
        click(dropdownLinkLocator);
        return new DropdownPage(driver, log);
    }

    /**
     * Open AlertsPage by clicking on JavaScript Alerts Link
     */
    public JavaScriptAlertsPage clickJavaScriptAlertsLink() {
        log.info("Clicking JavaScript Alerts link on Welcome Page");
        click(javaScriptAlertsLinkLocator);
        return new JavaScriptAlertsPage(driver, log);
    }

    /**
     * Open ContextMenuPage by clicking on Context Menu Link
     */
    public ContextMenuPage clickContextMenuLink() {
        log.info("Clicking Context Menu link on Welcome Page");
        click(contextMenuLinkLocator);
        return new ContextMenuPage(driver, log);
    }

    /**
     * Open MultipleWindowsPage by clicking on Multiple Windows Link
     */
    public MultipleWindowsPage clickMultipleWindowsLink() {
        log.info("Clicking Multiple Windows link on Welcome Page");
        click(multipleWindowsLinkLocator);
        return new MultipleWindowsPage(driver, log);
    }

    /**
     * Open WYSIWYGEditorPage by clicking on WYSIWYG Editor Link
     */
    public FrameEditorPage clickWYSIWYGEditorLink() {
        log.info("Clicking WYSIWYG Editor link on Welcome Page");
        click(editorLinkLocator);
        return new FrameEditorPage(driver, log);
    }

    /**
     * Open FramesPage by clicking on Frames Link
     */
    public FramesPage clickFramesLink() {
        log.info("Clicking Frames link on Welcome Page");
        click(framesLinkLocator);
        return new FramesPage(driver, log);
    }

    /**
     * Open KeyPressesPage by clicking on Key Presses Link
     */
    public KeyPressesPage clickKeyPressesLink() {
        log.info("Clicking Key Presses Link on Welcome Page");
        click(keyPressesLocator);
        return new KeyPressesPage(driver, log);
    }

    /**
     * Open FileUploaderPage by clicking on File Upload Link
     */
    public FileUploaderPage clickFileUploadLink() {
        log.info("Clicking File Upload Link on Welcome Page");
        click(fileUploadLocator);
        return new FileUploaderPage(driver, log);
    }

    /**
     * Open DragAndDropPage by clicking on Drag and Drop Link
     */
    public DragAndDropPage clickDragAndDropLink() {
        log.info("Clicking Drag and Drop Link on Welcome Page");
        click(dragAndDropLocator);
        return new DragAndDropPage(driver, log);
    }

    /**
     * Open HoversPage by clicking on Hovers Link
     */
    public HoversPage clickHoversLink() {
        log.info("Clicking Hovers Link on Welcome Page");
        click(hoversLocator);
        return new HoversPage(driver, log);
    }

    /**
     * Open HorizontalSliderPage by clicking on Horizontal Slider Link
     */
    public HorizontalSliderPage clickHorizontalSliderLink() {
        log.info("Clicking Horizontal Slider Link on Welcome Page");
        click(horizontalSliderLocator);
        return new HorizontalSliderPage(driver, log);
    }

    /**
     * Open LargeAndDeepDomPage by clicking on Large & Deep DOM Link
     */
    public LargeAndDeepDomPage clickLargeAndDeepDomLink() {
        log.info("Clicking Large And Deep Dom Link on Welcome Page");
        click(largeAndDeepDomLocator);
        return new LargeAndDeepDomPage(driver, log);
    }

    /**
     * Open InfiniteScrollPage by clicking on Infinite Scroll Link
     */
    public InfiniteScrollPage clickInfiniteScrollLink() {
        log.info("Clicking Infinite Scroll Link on Welcome Page");
        click(infiniteScrollLocator);
        return new InfiniteScrollPage(driver, log);
    }

    /**
     * Open InfiniteScrollPage by clicking on Infinite Scroll Link
     */
    public DynamicLoadingPage clickDynamicLoadingLink() {
        log.info("Clicking Infinite Scroll Link on Welcome Page");
        click(dynamicLoadingLocator);
        return new DynamicLoadingPage(driver, log);
    }
}
