import Constant.Constant;
import Railway.BookticketPage;
import Railway.HomePage;
import Railway.LoginPage;
import org.testng.annotations.Test;

public class TC14 extends BaseTest {

    @Test(description = "User can book many tickets at a time")
    public void BookTicketTC14() {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookticketPage bookticketPage = new BookticketPage();


        homePage.open();
        loginPage.gotoLoginPage();
        loginPage.Login(Constant.USENAME, Constant.PASSWORD);
        bookticketPage.gotoBookTickPage();
        bookticketPage.getDepartFrom();
//        bookticketPage.getArriveAt();
//        bookticketPage.getDepartDate();
//        bookticketPage.getTicketAmount();
//        bookticketPage.getSeatType();
    }
}
