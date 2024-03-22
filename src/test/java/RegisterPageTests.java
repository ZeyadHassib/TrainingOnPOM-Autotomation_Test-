import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterPageTests extends TestBase {
    private Base base;

    private HomePage homePage;
    private RegisterPage registerPage;


    @Test(testName = "TC_VerifySuccessfullyRegistration", description = "Test Registration with invalid data", priority = 1)
    public void TC_VerifySuccessfullyRegistration() {
        homePage = new HomePage(driver);
        homePage.waitElementToBeVisible(homePage.CreateAccountLocator);
        registerPage = homePage.ClickOnCreateAccount();
        registerPage.ClearTextFields();
        registerPage.SetAccountData("Ahmed", "Mahmoud", "Email113@Vaild.com", "123456Ahmed#", "123456Ahmed#");
        MyAccountPage myAccountPage = registerPage.SubmitAndRedirect();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String actual = myAccountPage.getRegisterationSuccessText();
        String expected = "Thank you for registering with Main Website Store.";
        softAssert.assertTrue(actual.contains(expected), "Actual: " + actual + " is not equal to Expected: " + expected);
        myAccountPage.logOut();
    }

    @Test(testName = "TC_VerifyFirstnameField", description = "Verify FirstName start with special character is not accepted")
    public void TC_VerifyFirstnameField() {
        homePage = new HomePage(driver);
        homePage.waitElementToBeVisible(homePage.CreateAccountLocator);
        registerPage = homePage.ClickOnCreateAccount();
        registerPage.ClearTextFields();
        registerPage.SetAccountData("&&ziad", "Mahmoud", "Ziad##@gmail.com", "123456Ahmed++", "123456Ahmed++");
        registerPage.getSubmit().click();
        String actual =registerPage.getNameErrorMsg();
        softAssert.assertEquals(actual,"First Name is not valid!\n");
        System.out.println(actual);

    }
    @Test(testName = "TC_VerifyLastnameField", description = "Verify LastName start with special character is not accepted")
    public void TC_VerifyLastnameField() {
        homePage = new HomePage(driver);
        homePage.waitElementToBeVisible(homePage.CreateAccountLocator);
        registerPage = homePage.ClickOnCreateAccount();
        registerPage.ClearTextFields();
        registerPage.SetAccountData("ziad", "&&Mahmoud", "Ziad##@gmail.com", "123456Ahmed++", "123456Ahmed++");
        registerPage.getSubmit().click();
        String actual =registerPage.getNameErrorMsg();
        softAssert.assertEquals(actual,"Last Name is not valid!\n");
        System.out.println(actual);

    }

    @Test(testName = "TC_VerifyAlreadyAccount", description = "Verify AlreadyAccount already account is not accepted")
    public void TC_VerifyAlreadyAccount() {
        homePage = new HomePage(driver);
        homePage.waitElementToBeVisible(homePage.CreateAccountLocator);
        registerPage = homePage.ClickOnCreateAccount();
        registerPage.ClearTextFields();
        registerPage.SetAccountData("Ahmed", "Mahmoud", "Email12@Vaild.com", "123456Ahmed#", "123456Ahmed#");
        registerPage.getSubmit().click();
        String actual =registerPage.getAlreadyAccountText();
        softAssert.assertEquals(actual,"There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.\n");
        System.out.println(actual);

    }

    @Test(testName = "TC_VerifyEmailFormatMsg", description = "Verify invalid email format is not accepted")
    public void TC_VerifyEmailFormatMsg() {
        homePage = new HomePage(driver);
        homePage.waitElementToBeVisible(homePage.CreateAccountLocator);
        registerPage = homePage.ClickOnCreateAccount();
        registerPage.ClearTextFields();
        registerPage.SetAccountData("", "", "", "123456Ahmed#", "123456Ahmed#");
        registerPage.getSubmit().click();
        String actual =registerPage.getEmailErrorText();
        softAssert.assertEquals(actual,"Please enter a valid email address (Ex: johndoe@domain.com).\n");
        System.out.println(actual);

    }
    @Test(testName = "TC_VerifyUnmatchedPassMsg", description = "Verify unmatched password and confirm password is not accepted")
    public void TC_VerifyUnmatchedPassMsg() {
        homePage = new HomePage(driver);
        homePage.waitElementToBeVisible(homePage.CreateAccountLocator);
        registerPage = homePage.ClickOnCreateAccount();
        registerPage.ClearTextFields();
        registerPage.SetAccountData("", "", "", "123456Ahmed++", "123456Ahmed#");
        registerPage.getSubmit().click();
        String actual =registerPage.getSamePassText();
        softAssert.assertEquals(actual,"Please enter the same value again.\n");
        System.out.println(actual);

    }


        @Test(testName = "TC_VerifyPassword",description = " Verify password Minimum length of  field equal or greater than 8 symbols")
        public void TC_VerifyPassword() {
            homePage = new HomePage(driver);
            homePage.waitElementToBeVisible(homePage.CreateAccountLocator);
            registerPage = homePage.ClickOnCreateAccount();
            registerPage.ClearTextFields();
            registerPage.SetAccountData("", "", "", "123456", "");
            String actual = registerPage.getPassErrorMessage();
            String expected;
            homePage.waitElementToBeVisible(registerPage.getPassErrorMessageLocator());
            System.out.println(actual);

            expected = "Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored";
            softAssert.assertTrue(actual.contains(expected), "Actual: " + actual + " is not equal to Expected: " + expected);

        }
            @Test(testName = "TC_VerifyPasswordClasses",description = " Verify password Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters.")
            public void TC_VerifyPasswordClasses() {
                homePage = new HomePage(driver);
                homePage.waitElementToBeVisible(homePage.CreateAccountLocator);
                registerPage = homePage.ClickOnCreateAccount();
                registerPage.ClearTextFields();
                registerPage.SetAccountData("", "", "", "12345678", "12345678");
                String actual = registerPage.getClassPassErroeText();
                System.out.println(actual);
                String expected = "Minimum of different classes of characters in password is 3.";
                softAssert.assertTrue(actual.contains(expected),"Different classes are not verified");
     }









}
