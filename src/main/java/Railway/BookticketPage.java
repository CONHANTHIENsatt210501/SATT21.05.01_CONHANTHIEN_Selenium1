package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class BookticketPage extends GeneralPage {

    //Locator
    private final By lblTicket = By.xpath("//div[@id='page']/div[@id='content']/h1[@align='center']");
    private final By cboDepartDate = By.xpath("//div[@id='content']/div/form//select[@name ='Date']");
    private final By btnBookTicket = By.xpath("//input[@value='Book ticket']");
    private final By lblMessageBookSuccess = By.xpath("//div[@id='content']/h1");

    //Dynamic Locator
    String dblDepartFrom = "//select[@name ='DepartStation']//option[text()='%s']";
    String dblArriveAt = "//select[@name ='ArriveStation']//option[text()='%s']";
    String dblSeatType = "//select[@name ='SeatType']//option[text()='%s']";
    String dblTicketAmount = "//select[@name='TicketAmount']//option[text()='%s']";
    String dblDepartDate="//div[@id='content']/div/form//select[@name ='Date']//option[text()='%s']";

    //Element
    protected WebElement getDblDepartDate(String departDate){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(dblDepartDate, departDate)));
    }

    protected WebElement getDblTicketAmount(String ticketAmount) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(dblTicketAmount, ticketAmount)));
    }

    protected WebElement getDblArriveAt(String arriveAt) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(dblArriveAt, arriveAt)));
    }

    protected WebElement getDblDepartFrom(String departFrom) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(dblDepartFrom, departFrom)));
    }

    protected WebElement getDblSeatType(String seatType) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(dblSeatType, seatType)));
    }


    protected WebElement getlblMessBookSuccess() {
        return Constant.WEBDRIVER.findElement(lblMessageBookSuccess);
    }

    protected WebElement getbtnBookTicket() {
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }


    protected WebElement getCboDepartDate() {
        return Constant.WEBDRIVER.findElement(cboDepartDate);
    }

    protected WebElement getLblTitleTicket() {
        return Constant.WEBDRIVER.findElement(lblTicket);
    }

    //Methods

    public String getLblMessBookSuccess() {
        return this.getlblMessBookSuccess().getText();
    }

    public void getBtnSubmitBookTicket() {
        try{
            new Actions(Constant.WEBDRIVER).moveToElement(this.getbtnBookTicket()).click().perform();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public String getTitleTicketText() {
        return this.getLblTitleTicket().getText();
    }

    public void getDepartDate() {
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        try{
            Calendar c = Calendar.getInstance();
            int day = c.get(c.DATE)+7;
            int month = c.get(c.MONTH)+1;
            int year = c.get(c.YEAR);
            String date = month+"/"+day+"/"+year;

            this.getDblDepartDate(date).click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void getDepartFrom(String departFrom){
        this.getDblDepartFrom(departFrom).click();

    }

    public void getArriveAt(String arrivalAt) {
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        this.getDblArriveAt(arrivalAt).click();
    }

    public void getSeatType(String seatType) {
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        this.getDblSeatType(seatType).click();
    }

    public void getTicketAmount(String ticketAmount) {
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        this.getDblTicketAmount(ticketAmount).click();
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
    }

}

