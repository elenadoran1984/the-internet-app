package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmailSentPage {

    private WebDriver driver;
    private By contentArea = By.id("content");
    private By errorServer = By.cssSelector("body > h1");

    public EmailSentPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getError() {
        return driver.findElement(errorServer).getText();
    }

    public String getMessage() {
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait.until(webDriver -> {
            try {
                return webDriver.findElement(contentArea).getText();
            } catch (StaleElementReferenceException e) {
                return null;
            }
        });
    }
}
