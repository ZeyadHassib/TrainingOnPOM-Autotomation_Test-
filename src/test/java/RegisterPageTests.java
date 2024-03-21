import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterPageTests extends TestBase {

    private HomePage homePage;
    private RegisterPage registerPage;
    private MyAccountPage myAccountPage;


    @Test(description = "Test Registration with Valid data and Invalid data",priority = 1)
    public void Registration() {
        homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        registerPage=homePage.ClickOnCreateAccount();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        registerPage.EnterFirstName("Ahmed");
        registerPage.EnterLastName("Samir");
        registerPage.EnterEmailAddress("me33333@me");
        registerPage.EnterPassword("123456Ahmed###");
        registerPage.EnterPasswordConfirmation("123456Ahmed###");
        myAccountPage=registerPage.ClickOnSubmit();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String actual = myAccountPage.chkRegisterationSuccess();
        String expected = "Thank you for registering with Main Website Store.";
        Assert.assertTrue(actual.contains(expected));
        myAccountPage.logOut();
    }
        @Test(description = "Test Registration with Valid data and Invalid data",priority = 2)

        public void InvalidRegistration() {
            homePage = new HomePage(driver);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            registerPage = homePage.ClickOnCreateAccount();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            registerPage.EnterFirstName("Ahmed");
            registerPage.EnterLastName("Samir");
            registerPage.EnterEmailAddress("me33333@me");
            registerPage.EnterPassword("123456Ahmed###");
            registerPage.EnterPasswordConfirmation("123456Ahmed###");
            myAccountPage = registerPage.ClickOnSubmit();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            String actual = myAccountPage.chkRegisterationSuccess();
            String expected = "Thank you for registering with Main Website Store.";
            Assert.assertTrue(actual.contains(expected));
            myAccountPage.logOut();

        }







}
