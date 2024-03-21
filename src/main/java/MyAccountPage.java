import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class MyAccountPage extends PageBase {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

        By SuccessfullRegistrationMsgLocator = By.className("message-success");
        By DropDownButton = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button");
        By signOut = By.xpath("//a[contains(text(), 'Sign Out')]");

        WebElement SuccessfullRegistrationMsg = driver.findElement(SuccessfullRegistrationMsgLocator);
        WebElement DropDownButtonElement = driver.findElement(DropDownButton);
        WebElement signOutElement = driver.findElement(signOut);

    public String chkRegisterationSuccess() {

        return SuccessfullRegistrationMsg.getText();
    }
    public void logOut() {

        ClickOnElement(DropDownButtonElement);
        ClickOnElement(signOutElement);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }
}
