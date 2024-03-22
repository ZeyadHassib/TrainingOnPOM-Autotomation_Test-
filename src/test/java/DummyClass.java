import org.testng.annotations.Test;

public class DummyClass extends TestBase{

    private HomePage homePage;
    private RegisterPage registerPage;
    private MyAccountPage myAccountPage;

    @Test(testName = "TC_VerifyAlreadyAccount", description = "Verify AlreadyAccount already account is not accepted")
    public void TC_VerifyAlreadyAccount() {
        homePage = new HomePage(driver);
        homePage.waitElementToBeVisible(homePage.CreateAccountLocator);
        registerPage = homePage.ClickOnCreateAccount();
        registerPage.SetAccountData("Ahmed", "Mahmoud", "Email12@Vaild.com", "123456Ahmed#", "123456Ahmed#");
        registerPage.SubmitAndRedirect();
        String actual =registerPage.getAlreadyAccountText();
        softAssert.assertEquals(actual,"There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.\n");
        System.out.println(actual);

    }
}
