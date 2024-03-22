import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public Base(WebDriver driver) {
        this.driver=driver;
    }

    public static void ClickOnElement(WebElement e) {

        e.click();
    }


    public static void enterData(WebElement e, String testData) {

        e.sendKeys(testData);
    }

    public MyAccountPage DriverToMyAccountPagee() {
        return new MyAccountPage(driver);
    }

    public RegisterPage DriverToRegisterPage() {
        return new RegisterPage(driver);
    }

    public HomePage DriverToHomePage() {
        return new HomePage(driver);
    }
    public LoginPage DriverToLoginPage() {
        return new LoginPage(driver);
    }





}
