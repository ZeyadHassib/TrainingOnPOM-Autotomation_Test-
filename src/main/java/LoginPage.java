import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageBase {


    public LoginPage(WebDriver driver) {

        super(driver);
    }
    private By emailLocator = By.cssSelector("input#email.input-text");
    private By passwordLocator = By.cssSelector("pass#email.input-text");

    private By signInButtonLocator = By.id("send2");

    private WebElement emailElement = driver.findElement(emailLocator);
    private WebElement passwordElement = driver.findElement(passwordLocator);
    private WebElement signInButton = driver.findElement(signInButtonLocator);


    public void enterEmail(String text) {
        enterData(emailElement,text);
    }

    public void enterPassword(String text) {
        enterData(passwordElement,text);
    }

    public MyAccountPage ClickOnSignInButton() {

        ClickOnElement(signInButton);
        return new MyAccountPage(driver);
    }

}
