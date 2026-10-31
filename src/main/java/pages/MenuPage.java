package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MenuPage {

    private WebDriver driver;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public int returnSizeElements() {
        List<WebElement> sizeElements = driver.findElements(By.cssSelector("#content > div > ul > li"));
        return sizeElements.size();
    }

    public List<String> returnNameElements() {
        List<WebElement> nameElements = driver.findElements(By.cssSelector("#content > div > ul > li > a"));
        List<String> names = new ArrayList<String>();
        for (WebElement element : nameElements) {
            String name = element.getText();
            names.add(name);
        }
        return names;
    }

}