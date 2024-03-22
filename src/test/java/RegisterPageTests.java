import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterPageTests extends TestBase {

    private HomePage homePage;
    private RegisterPage registerPage;
    private MyAccountPage myAccountPage;


    @Test(testName = "TC_VerifySuccessfullRegistration", description = "Test Registration with Valid data")
    public void TC_VerifySuccessfullRegistration() {
        homePage = new HomePage(driver);
        homePage.waitElementToBeVisible(homePage.CreateAccountLocator);
        registerPage = homePage.ClickOnCreateAccount();
        registerPage.SetAccountData("Ahmed", "Mahmoud", "Email7@Vaild.com", "123456Ahmed#", "123456Ahmed#");

        myAccountPage = registerPage.ClickOnSubmit();


        String actual = myAccountPage.chkRegisterationSuccess();
        String expected = "Thank you for registering with Main Website Store.";
        Assert.assertTrue(actual.contains(expected), "Actual: " + actual + " is not equal to Expected: " + expected);

        myAccountPage.logOut();
    }









}
