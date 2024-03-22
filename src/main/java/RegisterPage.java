import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage extends Base {


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    private final By FirstName = By.id("firstname");
    private final By LastName = By.id("lastname");
    private final By EmailAddress = By.id("email_address");
    private final By Password = By.id("password");
    private final By PasswordConfirmation = By.id("password-confirmation");
    private final By errorPasswordLength=By.xpath("/html/body/div[2]/main/div[3]/div/form/fieldset[2]/div[2]/div/div[1]");

    private final By CreateAccountButton = By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button");
    private final By AlreadyAccountLinkLocator = By.xpath("//div[@class='message-error error message']");
    private final By SamePassTextLocator = By.xpath("//div[@id='password-confirmation-error']");
    private final By ClassPassErrorTextLocator = By.xpath("//div[@id='password-error']");
    private final By EmailMsgLocator = By.cssSelector("#email_address-error.mage-error");
    private final By nameErrorMsg = By.xpath("/html/body/div[2]/main/div[2]/div[2]/div/div/div");


    private final WebElement Pass_error_msgElement = driver.findElement(errorPasswordLength);


    private final WebElement FirstNameElement = driver.findElement(FirstName);
    private final WebElement LastNameElement = driver.findElement(LastName);
    private final WebElement EmailAddressElement = driver.findElement(EmailAddress);
    private final WebElement PasswordElement = driver.findElement(Password);
    private final WebElement PasswordConfirmationElement = driver.findElement(PasswordConfirmation);
    private final WebElement SubmitButton = driver.findElement(CreateAccountButton);




    public void SetAccountData(String fname, String lname, String email, String pass, String Confirmpass) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        enterData(FirstNameElement,fname);
        enterData(LastNameElement,lname);
        enterData(EmailAddressElement,email);
        enterData(PasswordElement,pass);
        enterData(PasswordConfirmationElement,Confirmpass);
    }
    public void ClearTextFields() {
        FirstNameElement.clear();
        LastNameElement.clear();
        EmailAddressElement.clear();
        PasswordElement.clear();
        PasswordConfirmationElement.clear();

    }
    public MyAccountPage SubmitAndRedirect() {

        ClickOnElement(SubmitButton);
        return new MyAccountPage(driver);
    }

    public String getPassErrorMessage() {
        wait=new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorPasswordLength));
        return driver.findElement(errorPasswordLength).getText();
    }
    public String getAlreadyAccountText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(AlreadyAccountLinkLocator));
        return driver.findElement(AlreadyAccountLinkLocator).getText();
    }

    public String getSamePassText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SamePassTextLocator));
        return driver.findElement(SamePassTextLocator).getText();
    }
    public String getClassPassErroeText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ClassPassErrorTextLocator));
        return driver.findElement(ClassPassErrorTextLocator).getText();
    }

    public String getEmailErrorText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(EmailMsgLocator));
        return driver.findElement(EmailMsgLocator).getText();
    }

    public String getNameErrorMsg() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameErrorMsg));
        return driver.findElement(nameErrorMsg).getText();
    }

    public String LastnameErrorMsg() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameErrorMsg));
        return driver.findElement(nameErrorMsg).getText();
    }


    public By getPassErrorMessageLocator() {

        return errorPasswordLength;
    }

    public WebElement getSubmit() {

    return SubmitButton;
    }


}
