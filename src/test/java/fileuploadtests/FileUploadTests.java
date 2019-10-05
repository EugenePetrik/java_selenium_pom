package fileuploadtests;

import base.TestUtilities;
import org.testng.annotations.Test;
import pages.FileUploaderPage;
import pages.WelcomePage;

import static org.testng.Assert.assertTrue;

public class FileUploadTests extends TestUtilities {

    @Test(groups = { "smokeTests" })
    public void fileUploadTest() {
        log.info("Starting File Upload Test");

        // Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on File Upload link
        FileUploaderPage fileUploaderPage = welcomePage.clickFileUploadLink();

        // Select file
        String fileName = "logo.png";
        fileUploaderPage.selectFile(fileName);

        // Push upload button
        fileUploaderPage.pushUploadButton();

        // Get uploaded files
        String fileNames = fileUploaderPage.getUploadedFilesNames();

        // Verify selected file uploaded
        assertTrue(fileName.contains(fileNames),
                "Our file (" + fileName + ") is not one of the uploaded (" + fileNames + ")");
    }
}
