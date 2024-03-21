import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {

    protected WebDriver driver;
    protected WebDriver Wait;

    public PageBase(WebDriver driver) {
        this.driver=driver;
    }

    public static void ClickOnElement(WebElement e) {

        e.click();
    }

    public static void enterData(WebElement e, String testData) {

        e.sendKeys(testData);
    }





}
