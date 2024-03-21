import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class RegisterPageTests extends TestBase {
    SoftAssert softAssert = new SoftAssert();


    private HomePage homePage;
    private RegisterPage registerPage;
    private MyAccountPage myAccountPage;


    @DataProvider(name = "Test-data")
    public Object[][] dpMethod() {
        return new Object[][] {

                {"Ahmed","aaaa","Dods1z0y@d22ody.com","123456Ahmed#","123456Ahmed#",true},
                {"++Ahmed","aaaa","D0z1sody@1dody.com","123456Ahmed#","123456Ahmed#",false},
                {"9Ahmed","aaaa","Do0zsdy@2do1dy.com","123456Ahmed#","123456Ahmed#",false},
                {"","aaaa","Dody@3do1zsdy.com","123456Ahmed#","123456Ahmed#",false},
                {"Ahmed","++aaaa","Dozs01dy@41dody.com","123456Ahmed#","123456Ahmed#",false},
                {"Ahmed","aaaa","++Dozs0dy@5d1ody.com","123456Ahmed#","123456Ahmed#",false},
                {"Ahmed","aaaa","Do0szdy@6do1dy.com","123456Ahmed","123456Ahmed#",false},
        };
    }
    @Test(description = "Test Registration with Valid data and Invalid data", dataProvider = "Test-data")
    public void Registration(String fname,String lname,String email,String pass,String confirmPass,Boolean exp) {
        homePage = new HomePage(driver);
        homePage.waitElementToBeVisible(homePage.CreateAccountLocator);
        registerPage = homePage.ClickOnCreateAccount();
        registerPage.EnterFirstName(fname);
        registerPage.EnterLastName(lname);
        registerPage.EnterEmailAddress(email);
        registerPage.EnterPassword(pass);
        registerPage.EnterPasswordConfirmation(confirmPass);
        myAccountPage = registerPage.ClickOnSubmit();


        String actual = myAccountPage.chkRegisterationSuccess();
        String expected = "Thank you for registering with Main Website Store.";

        softAssert.assertTrue(actual.contains(expected), "Actual: " + actual + " is not equal to Expected: " + expected);
        softAssert.assertEquals(exp.booleanValue(),true,"Test Failed");
        myAccountPage.logOut();
        softAssert.assertAll();

    }









}
