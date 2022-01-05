import Common.JsonHelper;
import Common.Utilities;
import Constant.Constant;
import Railway.BookticketPage;
import Railway.HomePage;
import Railway.LoginPage;
import Railway.MyTicketPage;
import com.google.gson.JsonObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC16 extends BaseTest {

    @Test(description = "User can cancel a ticket", dataProvider = "data-provider")
    public void MyticketTC16(String departStation, String arriveStation, String seatType, String ticketAmount) {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookticketPage bookticketPage = new BookticketPage();
        MyTicketPage myTicketPage = new MyTicketPage();
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        System.out.println("2. Login with a valid account");
        loginPage.gotoLoginPage();
        loginPage.Login(Constant.USENAME, Constant.PASSWORD);
        System.out.println("3. Book a ticket");
        bookticketPage.gotoBookTickPage();
        bookticketPage.getDepartDate();
        bookticketPage.getDepartFrom(departStation);
        bookticketPage.getArriveAt(departStation);
        bookticketPage.getSeatType(seatType);
        bookticketPage.getTicketAmount(ticketAmount);
        System.out.println("4. Click on My ticket tab");
        myTicketPage.gotoMyTicket();
        System.out.println("5. Click on Cancel button of ticket which user want to cancel.");
        myTicketPage.deleteTicket(3);
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() {
        JsonObject jsonObject = JsonHelper.getJsonObject(Utilities.jsonProjectPath());
        JsonObject dataTC16 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departStation = dataTC16.get("Depart from").getAsString();
        String arriveStation = dataTC16.get("Arrive at").getAsString();
        String seatType = dataTC16.get("Seat type").getAsString();
        String ticketAmount = dataTC16.get("Ticket amount").getAsString();
        Object[][] object = new Object[][]{
                {departStation, arriveStation, seatType, ticketAmount}
        };
        return object;
    }
}
