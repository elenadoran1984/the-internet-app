package alerts;

import base.BaseTests;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.util.Objects;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {

    @Test(enabled = false)
    public void testFileUploadLocal(){
        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("absolutePath/testSuccessfulLogin.png");
        assertEquals(uploadPage.getUploadedFiles(), "testSuccessfulLogin.png", "Uploaded failed");
    }

    @Test
    public void testFileUpload() throws Exception {
        var uploadPage = homePage.clickFileUpload();
        var fileResource = Objects.requireNonNull(
                getClass().getResource("/testSuccessfulLogin.png"),
                "Test image not found!"
        );
        String filePath = Path.of(fileResource.toURI())
                .toAbsolutePath()
                .toString();
        uploadPage.uploadFile(filePath);
        assertEquals(
                uploadPage.getUploadedFiles(),
                "testSuccessfulLogin.png",
                "Upload failed"
        );
    }
}
