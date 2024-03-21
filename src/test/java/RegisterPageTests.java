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


    @Test(description = "Test Registration with Valid data and Invalid data")
    public void Registration() {
        homePage = new HomePage(driver);
        homePage.waitElementToBeVisible(homePage.CreateAccountLocator);
        registerPage = homePage.ClickOnCreateAccount();
        registerPage.EnterFirstName("Ahmed");
        registerPage.EnterLastName("Samir");
        registerPage.EnterEmailAddress("me3z4pz4437p33@me.com");
        registerPage.EnterPassword("123456Ahmed###");
        registerPage.EnterPasswordConfirmation("123456Ahmed###");
        myAccountPage = registerPage.ClickOnSubmit();


        String actual = myAccountPage.chkRegisterationSuccess();
        String expected = "Thank you for registering with Main Website Store.";
        Assert.assertTrue(actual.contains(expected), "Actual: " + actual + " is not equal to Expected: " + expected);

        myAccountPage.logOut();
    }









}
