package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BookticketPage extends GeneralPage {

    //Selectror
    private final By lblTicket = By.xpath("//div[@id='page']/div[@id='content']/h1[@align='center']");
    private final By cboDepartDate = By.xpath("//div[@id='content']/div/form//select[@name ='Date']");
    private final By cboDepartFrom = By.xpath("//div[@id='content']/div/form//select[@name ='DepartStation']");
    private final By cboArriveAt = By.xpath("//div[@id='content']/div/form//select[@name='ArriveStation']");
    private final By cboSeatStyle = By.xpath("//div[@id='content']/div/form//select[@name='SeatType']");
    private final By cboTicketAmount = By.xpath("//div[@id='content']/div/form//select[@name='TicketAmount']");

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
        int count = allDepartFrom.size();
        do {
            for (int i = 0; i < allDepartFrom.size(); i++) {
                String local = allDepartFrom.get(i).getText();
                if (local.equals("Nha Trang")) {
                    WebElement xpa = allDepartFrom.get(i);
                    xpa.click();
                } else {
                    count--;
                }
            }
        } while (count != 0);
        Constant.WEBDRIVER.navigate().refresh();
        getDepartFrom();
    }

    public void getArriveAt() {
        Select arriveAt = new Select(getCboArriveAt());
        List<WebElement> allArriveAt = arriveAt.getOptions();
        int count = allArriveAt.size();
        do {
            for (int i = 0; i < allArriveAt.size(); i++) {
                String local = allArriveAt.get(i).getText();
                if (local.equals("Sài Gòn")) {
                    WebElement xpa = allArriveAt.get(i);
                    xpa.click();
                } else {
                    count--;
                }
            }
        } while (count != 0);
    }

    public void getSeatType(){
        
    }

}
