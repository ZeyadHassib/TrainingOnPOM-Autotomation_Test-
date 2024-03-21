import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageBase {

    protected WebDriver driver;

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
