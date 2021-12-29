import Constant.Constant;
import Railway.HomePage;
import Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class TC06 extends BaseTest {

    @Test(description = "TC06 - User is redirected to Home page after logging out")
    public void LogoutTC06() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        //navigate home
        homePage.open();
        loginPage.gotoLoginPage();

        //login page
        loginPage.Login(Constant.USENAME, Constant.PASSWORD);


        String actualMsg = loginPage.goToLogoutPageSuccess();
        String expectedMsg = "Success";
        //compare conditions
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome msg is not display as expected");
        System.out.println("Test Case Run");
    }

}
