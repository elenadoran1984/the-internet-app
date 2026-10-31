package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShiftingContentPage {

    private WebDriver driver;
    private By menuElement = By.linkText("Example 1: Menu Element");

    public ShiftingContentPage (WebDriver driver) {
        this.driver = driver;
    }

    public MenuPage clickMenuElement() {
        driver.findElement(menuElement).click();
        return new MenuPage(driver);
    }
}
