import Common.AccountRandom;
import Railway.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09 extends BaseTest {

    @Test(description = "User can't change password when New Password and Confirm Password are different.")
    public void changePasswordTC09() {
        HomePage homePage = new HomePage();
        LoginPage login = new LoginPage();
        RegisterPage registerPage = new RegisterPage();
        ChangePassword changepass = new ChangePassword();
        AccountRandom accountRandom = new AccountRandom();

        homePage.open();
        registerPage.gotoRegister();
        registerPage.register(
                accountRandom.createEmail(),
                accountRandom.createPassword(),
                accountRandom.checkConfirm(accountRandom.createPassword()),
                accountRandom.createPid());
        login.gotoLoginPage();
        login.Login(accountRandom.createEmail(), accountRandom.createPassword());
        changepass.gotoChangePassword();
        changepass.changePassword("123456789", "123456789", "1234567890");

        String actualMsg = changepass.getErrorMessage();
        String expectedMsg = "Password change failed. Please correct the errors and try again.";

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome msg is not display as expected");
    }
}
