package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WysiwygEditorPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private String editorIframeId = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By decreaseIndentButton = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div[1]/div[2]/div/div[5]/button[2]");

    public WysiwygEditorPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clearTextArea(){
        switchToEditArea();
        driver.findElement(textArea).clear();
        switchToMainArea();
    }

    public void setTextArea(String text){
        switchToEditArea();
        var editor = driver.findElement(textArea);
        editor.click();
        editor.sendKeys(text);
        switchToMainArea();
    }

    public void setTextArea2(String text) {
        switchToEditArea();
        WebElement editor = wait.until(
                ExpectedConditions.visibilityOfElementLocated(textArea)
        );
        editor.click();
        editor.sendKeys(text);
        System.out.println("EDITOR CONTENT: " + editor.getText());
        switchToMainArea();
    }

    public void decreaseIndention(){
        driver.findElement(decreaseIndentButton).click();
    }

    public String getTextFromEditor(){
        switchToEditArea();
        String text = driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }

    private void switchToEditArea(){
        driver.switchTo().frame(editorIframeId);
    }

    private void switchToMainArea(){
        driver.switchTo().parentFrame();
    }
}
