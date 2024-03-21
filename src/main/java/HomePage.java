import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {

        super(driver);
    }

    By SignInLocator = By.xpath("//html/body/div[2]/header/div/div/ul/li[2]/a[1]");
    By CreateAccountLocator = By.xpath("//html/body/div[2]/header/div/div/ul/li[3]/a[1]");
    
    WebElement CreateAccountLink = driver.findElement(CreateAccountLocator);
    public RegisterPage ClickOnCreateAccount() {
        
        ClickOnElement(CreateAccountLink);
        return new RegisterPage(driver);

    }

    WebElement SignInLink = driver.findElement(SignInLocator);
    public LoginPage ClickOnSignIn() {

        ClickOnElement(SignInLink);
        return new LoginPage(driver);
    }
}
