import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class RegisterPage extends PageBase {


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    private By FirstName = By.id("firstname");
    private By LastName = By.id("lastname");
    private By EmailAddress = By.id("email_address");
    private By Password = By.id("password");
    private By PasswordConfirmation = By.id("password-confirmation");

    private By CreateAccountButton = By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button");

    private WebElement FirstNameElement = driver.findElement(FirstName);
    private WebElement LastNameElement = driver.findElement(LastName);
    private WebElement EmailAddressElement = driver.findElement(EmailAddress);
    private WebElement PasswordElement = driver.findElement(Password);
    private WebElement PasswordConfirmationElement = driver.findElement(PasswordConfirmation);
    private WebElement SubmitButton = driver.findElement(CreateAccountButton);



    public void SetAccountData(String fname, String lname, String email, String pass, String Confirmpass) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        enterData(FirstNameElement,fname);
        enterData(LastNameElement,lname);
        enterData(EmailAddressElement,email);
        enterData(PasswordElement,pass);
        enterData(PasswordConfirmationElement,Confirmpass);
    }
    public MyAccountPage ClickOnSubmit() {

        ClickOnElement(SubmitButton);
        return new MyAccountPage(driver);
    }

}
