import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage extends Base {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

        By SuccessfullRegistrationMsgLocator = By.className("message-success");

        By DropDownButtonLocator = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button");
        By SignOutLocator = By.xpath("//a[contains(text(), 'Sign Out')]");

        WebElement SuccessfullRegistrationMsg = driver.findElement(SuccessfullRegistrationMsgLocator);

        WebElement DropDownButtonElement = driver.findElement(DropDownButtonLocator);
        WebElement signOutElement = driver.findElement(SignOutLocator);

    public String getRegisterationSuccessText() {
        wait=new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SuccessfullRegistrationMsgLocator));
        return SuccessfullRegistrationMsg.getText();
    }

    public void logOut() {
        wait=new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SuccessfullRegistrationMsgLocator));
        ClickOnElement(DropDownButtonElement);
        ClickOnElement(signOutElement);


    }
}
