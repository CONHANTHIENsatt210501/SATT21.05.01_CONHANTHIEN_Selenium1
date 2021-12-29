import Constant.Constant;
import Railway.HomePage;
import Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;


public class TC03 extends BaseTest {

    @Test(description = "TC03 - User cannot log into Railway with invalid password")
    public void LoginTC03(){
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        homePage.open();

        loginPage.gotoLoginPage();
        loginPage.Login(Constant.USENAME, "");


        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome msg is not display as expected");
        System.out.println("Test Case Run");
    }

}
