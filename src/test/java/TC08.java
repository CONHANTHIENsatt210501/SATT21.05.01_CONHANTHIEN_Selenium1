import Common.AccountRandom;
import Railway.HomePage;
import Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC08 extends BaseTest {

    @Test(description = "User can't login with an account hasn't been activated")
    public void LoginTC08() {
        HomePage home = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        AccountRandom accountRandom = new AccountRandom();
        home.open();

        registerPage.gotoRegister();

        registerPage.register(
                accountRandom.createEmail(),
                accountRandom.createPassword(),
                accountRandom.createConfirmSucess(),
                accountRandom.createPid());

        String actualMsg = registerPage.getMgsRegisterAccountUsed();
        String expectedMsg = "Thank you for registering your account";

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome msg is not display as expected");
    }
}
