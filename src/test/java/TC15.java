import Constant.Constant;
import Railway.HomePage;
import Railway.LoginPage;
import Railway.TimetablePage;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC15 extends BaseTest{

    @Test(description = "Ticket price page displays with ticket details after clicking on check price link in Train timetable page")
    public void ticketPrice() throws IOException, ParseException {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        TimetablePage timetablePage = new TimetablePage();

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        System.out.println("2. Login with a valid account");
        loginPage.gotoLoginPage();
        loginPage.Login(Constant.USENAME,Constant.PASSWORD);
        System.out.println("3. Click on Timetable tab");
        timetablePage.gotoTabTimeTable();
        System.out.println("4. Click on check price link of the route from Đà Nẵng to Sài Gòn");
        timetablePage.getCheckpriceTable();

        String excepMsg = "Ticket price from Sài Gòn to Phan Thiết";
        String actualMsg = timetablePage.getLblMessage();
        Assert.assertEquals(actualMsg,excepMsg,"Welcome msg is not display as expected");
    }

}
