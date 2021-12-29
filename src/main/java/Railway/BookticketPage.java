package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BookticketPage extends GeneralPage {

    //Locator
    private final By lblTicket = By.xpath("//div[@id='page']/div[@id='content']/h1[@align='center']");
    private final By cboDepartDate = By.xpath("//div[@id='content']/div/form//select[@name ='Date']");
    private final By cboDepartFrom = By.xpath("//select[@name ='DepartStation']");
    private final By cboArriveAt = By.xpath("//select[@name='ArriveStation']");
    private final By cboSeatStyle = By.xpath("//select[@name='SeatType']");
    private final By cboTicketAmount = By.xpath("//select[@name='TicketAmount']");

    //Element
    protected WebElement getCboDepartDate() {
        return Constant.WEBDRIVER.findElement(cboDepartDate);
    }

    protected WebElement getCboDepartFrom() {
        return Constant.WEBDRIVER.findElement(cboDepartFrom);
    }

    protected WebElement getCboArriveAt() {
        return Constant.WEBDRIVER.findElement(cboArriveAt);
    }

    protected WebElement getCboSeatStyle() {
        return Constant.WEBDRIVER.findElement(cboSeatStyle);
    }

    protected WebElement getCboTicketAmount() {
        return Constant.WEBDRIVER.findElement(cboTicketAmount);
    }

    protected WebElement getLblTitleTicket() {
        return Constant.WEBDRIVER.findElement(lblTicket);
    }

    //Methods

    public String getTitleTicketText() {
        return this.getLblTitleTicket().getText();
    }

    public void getDepartDate() {
        Select departDate = new Select(getCboDepartDate());
        departDate.selectByIndex(3);
    }


    public void getDepartFrom() {
        Select departFrom = new Select(getCboDepartFrom());
        List<WebElement> allDepartFrom = departFrom.getOptions();
        String local;
        boolean flag = false;
        {
            do {
                for (int i = 0; i < allDepartFrom.size(); i++) {
                    local = allDepartFrom.get(i).getText();
                    if (local.equals("Nha Trang")) {
                        Constant.WEBDRIVER.findElement(By.xpath("//select[@name ='DepartStation']//option[text()='Nha Trang']")).click();
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    Constant.WEBDRIVER.navigate().refresh();
                    getDepartFrom();
                }
            } while (flag == false);

        }

//        public void getArriveAt () {
//            Select arriveAt = new Select(getCboArriveAt());
//            List<WebElement> allArriveAt = arriveAt.getOptions();
//            int count = allArriveAt.size();
//            do {
//                for (int i = 0; i < allArriveAt.size(); i++) {
//                    String local = allArriveAt.get(i).getText();
//                    if (local.equals("Sài Gòn")) {
//                        Constant.WEBDRIVER.findElement(By.xpath("//select[@name ='ArriveStation']//option[text()='Sài Gòn']")).click();
//                        count = 0;
//                    } else {
//                        count--;
//                    }
//                }
//            } while (count != 0);
//            Constant.WEBDRIVER.navigate().refresh();
//            getDepartFrom();
//        }

//        public void getSeatType () {
//            Select seatType = new Select(getCboSeatStyle());
//            List<WebElement> allSeat = seatType.getOptions();
//            int count = allSeat.size();
//            for (int i = 0; i < allSeat.size(); i++) {
//                String seat = allSeat.get(i).getText();
//                if (seat.equals("Soft seat")) {
//                    Constant.WEBDRIVER.findElement(By.xpath("//select[@name ='SeatType']//option[text()='Soft seat']")).click();
//                    break;
//                } else {
//                    count--;
//                }
//            }
//        }

//        public void getTicketAmount () {
//            Select ticketAmount = new Select(getCboTicketAmount());
//            List<WebElement> allTicket = ticketAmount.getOptions();
//            int count = allTicket.size();
//            for (int i = 0; i < allTicket.size(); i++) {
//                String ticket = allTicket.get(i).getText();
//                if (ticket.equals("4")) {
//                    Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']/div/form//select[@name ='TicketAmount']//option[text()='4']")).click();
//                    break;
//                } else {
//                    count--;
//                }
//            }
//        }
    }
}
