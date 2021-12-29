import Constant.Constant;
import Railway.HomePage;
import Railway.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import sun.plugin.com.BeanCustomizer;

import javax.xml.ws.Holder;

public class TC05 extends BaseTest {

    @Test(description = "TC05 - System shows message when user enters wrong password several times")
    public void LoginTC05() {
        HomePage homePage = new HomePage();
        LoginPage login = new LoginPage();
        homePage.open();

        login.gotoLoginPage();
        //test login function when user login invalid many time.
        login.LoginMutilTime("", "", 4);

        String actualMsg = login.getLoginErrorMsg();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        //compare conditions
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome msg is not display as expected");
        System.out.println("Test Case Run");

    }

}

