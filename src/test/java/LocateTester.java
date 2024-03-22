import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LocateTester {

    public static void main(String[] args) {

        By FirstName = By.id("firstname");
        By LastName = By.id("lastname");
        By EmailAddress = By.id("email_address");
        By Password = By.id("password");
        By PasswordConfirmation = By.id("password-confirmation");
        By Submit = By.id("password-confirmation");
        By CreateAccountButton = By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button");



        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
        driver.findElement(FirstName).sendKeys("Loctaor");
        driver.findElement(LastName).sendKeys("Master");
        driver.findElement(EmailAddress).sendKeys("Email12@Valid.com");
        driver.findElement(Password).sendKeys("123456test#");
        driver.findElement(PasswordConfirmation).sendKeys("123456test#");
        driver.findElement(CreateAccountButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button")));

        String See = driver.findElement(By.cssSelector("[data-bind=\"html: $parent.prepareMessageForHtml(message.text)\"]")).getText();

        System.out.println(See);
        driver.quit();

    }

}
