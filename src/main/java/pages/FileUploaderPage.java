package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class FileUploaderPage extends BasePageObject {

    private By choseFileFieldLocator = By.id("file-upload");
    private By uploadButtonLocator = By.id("file-submit");
    private By uploadedFilesLocator = By.id("uploaded-files");

    public FileUploaderPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Push Upload button
     */
    public void pushUploadButton() {
        log.info("Clicking on upload button");
        click(uploadButtonLocator);
    }

    /**
     * Select file
     */
    public void selectFile(String fileName) {
        log.info("Selecting '" + fileName + "' file from Files folder");
        String filePath = System.getProperty("user.dir") + File.separator +
                "src" + File.separator +
                "test" + File.separator +
                "resources" + File.separator +
                "dataproviders" + File.separator +
                "files" + File.separator +
                fileName;
        type(filePath, choseFileFieldLocator);
        log.info("File selected");
    }

    /**
     * Get names of uploaded files
     */
    public String getUploadedFilesNames() {
        String names = find(uploadedFilesLocator).getText();
        log.info("Uploaded files: " + names);
        return names;
    }
}
