package fileuploadtests;

import base.TestUtilities;
import org.testng.annotations.Test;
import pages.FileUploaderPage;
import pages.WelcomePage;

import static org.testng.Assert.assertTrue;

public class FileUploadTests extends TestUtilities {

    @Test(groups = { "smokeTests" }, dataProvider = "files")
    public void fileUploadTest(int number, String fileName) {
        log.info("Starting File Upload Test #" + number + " for " + fileName);

        // Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on File Upload link
        FileUploaderPage fileUploaderPage = welcomePage.clickFileUploadLink();

        // Select file
        fileUploaderPage.selectFile(fileName);

        // Push upload button
        fileUploaderPage.pushUploadButton();

        // Get uploaded files
        String fileNames = fileUploaderPage.getUploadedFilesNames();

        // Verify that selected file is uploaded
        assertTrue(fileName.contains(fileNames),
                "Our file (" + fileName + ") is not one of the uploaded (" + fileNames + ")");
    }
}
