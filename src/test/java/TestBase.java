import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestBase {

    protected WebDriver driver;
    protected SoftAssert softAssert;



    @BeforeTest

    public void setup() {

        driver = new EdgeDriver();
        softAssert = new SoftAssert();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");


    }




    @AfterTest
    public void quite() {

     driver.quit();

    }
}
