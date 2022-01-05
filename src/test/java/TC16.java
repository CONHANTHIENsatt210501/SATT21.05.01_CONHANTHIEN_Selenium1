import Constant.Constant;
import Railway.HomePage;
import Railway.LoginPage;
import Railway.MyTicketPage;
import org.testng.annotations.Test;

public class TC16 extends BaseTest{

    @Test(description = "User can cancel a ticket")
    public void MyticketTC16(){
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        MyTicketPage myTicketPage = new MyTicketPage();

        homePage.open();
        loginPage.gotoLoginPage();
        loginPage.Login(Constant.USENAME,Constant.PASSWORD);
        myTicketPage.gotoMyTicket();
        System.out.println(myTicketPage.getData());
    }
}
