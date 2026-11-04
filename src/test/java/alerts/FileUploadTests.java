package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {

    @Test
    public void testFileUpload(){
        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("C:\\Users\\Elena\\Desktop\\the-internet-app\\resources\\testSuccessfulLogin.png");
        assertEquals(uploadPage.getUploadedFiles(), "testSuccessfulLogin.png", "Uploaded failed");
    }
}
