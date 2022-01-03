import Constant.Constant;
import Railway.BookticketPage;
import Railway.HomePage;
import Railway.LoginPage;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC14 extends BaseTest {

    @Test(description = "User can book many tickets at a time")
    public void BookTicketTC14() throws IOException, ParseException, InterruptedException {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookticketPage bookticketPage = new BookticketPage();

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        System.out.println("2. Login with a valid account ");
        loginPage.gotoLoginPage();
        loginPage.Login(Constant.USENAME, Constant.PASSWORD);
        System.out.println("3. Click on Book ticket tab");
        bookticketPage.gotoBookTickPage();

        System.out.println("5. Select Nha Trang for Depart from and Sài Gòn for Arrive at.");
        bookticketPage.getDepartDate();
        bookticketPage.getDepartFrom();
        bookticketPage.getArriveAt();
        System.out.println("6. Select Soft seat with air conditioner for Seat type");
        bookticketPage.getSeatType();
        System.out.println("7. Select 5 for Ticket amount");
        bookticketPage.getTicketAmount();
        System.out.println("8. Click on Book ticket button");
        bookticketPage.getBtnSubmitBookTicket();

        String actualMsg = bookticketPage.getLblMessBookSuccess();
        String expectedMsg = "Ticket Booked Successfully!";

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome msg is not display as expected");
        System.out.println("Test Case Run");
    }
}
