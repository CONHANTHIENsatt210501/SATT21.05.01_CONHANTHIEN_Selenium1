package Railway;

import Constant.Constant;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class BookticketPage extends GeneralPage {

    //Locator
    private final By lblTicket = By.xpath("//div[@id='page']/div[@id='content']/h1[@align='center']");
    private final By cboDepartDate = By.xpath("//div[@id='content']/div/form//select[@name ='Date']");
    private final By cboDepartFrom = By.xpath("//select[@name ='DepartStation']");
    private final By cboArriveAt = By.xpath("//select[@name='ArriveStation']");
    private final By cboSeatStyle = By.xpath("//select[@name='SeatType']");
    private final By cboTicketAmount = By.xpath("//select[@name='TicketAmount']");
    private final By localDepartFrom = By.xpath("//select[@name ='DepartStation']//option[text()='Nha Trang']");
    private final By localArriveAt = By.xpath("//select[@name ='ArriveStation']//option[text()='Sài Gòn']");
    private final By seatTypeSoftSeat = By.xpath("//select[@name ='SeatType']//option[text()='Soft seat']");
    private final By btnBookticket = By.xpath("//input[@value='Book ticket']");
    private final By lblMessageBookSuccess = By.xpath("//div[@id='content']/h1");

    //Element(
    protected WebElement getlblMessBookSuccess(){
        return Constant.WEBDRIVER.findElement(lblMessageBookSuccess);
    }

    protected WebElement getBtnBookTicket() {
        return Constant.WEBDRIVER.findElement(btnBookticket);
    }

    protected WebElement getSeatTypeSoftSeat() {
        return Constant.WEBDRIVER.findElement(seatTypeSoftSeat);
    }

    protected WebElement getLocalArriveAt() {
        return Constant.WEBDRIVER.findElement(localArriveAt);
    }

    protected WebElement getLocalDepartFrom() {
        return Constant.WEBDRIVER.findElement(localDepartFrom);
    }

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
    public String getLblMessBookSuccess(){
        return this.getlblMessBookSuccess().getText();
    }

    public void getBtnSubmitBookTicket() {
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        this.getBtnBookTicket().click();
    }


    public String getTitleTicketText() {
        return this.getLblTitleTicket().getText();
    }

    public void getDepartDate() {
        Select departDate = new Select(getCboDepartDate());
        departDate.selectByIndex(3);
    }

    public void getDepartFrom() throws IOException, ParseException, InterruptedException {
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        Select departFrom = new Select(getCboDepartFrom());
        List<WebElement> allDepartFrom = departFrom.getOptions();
        JSONObject jsonObject = callJSON("src/main/java/Constant/data.json", 0);
        JSONObject jsonObject1 = (JSONObject) jsonObject.get("TC14");
        String localTestDepart = (String) jsonObject1.get("Depart from");
        String localDepart;
        boolean flag = false;
        try {
            do {
                for (int i = 0; i < allDepartFrom.size(); i++) {
                    localDepart = allDepartFrom.get(i).getText();
                    if (localDepart.equals(localTestDepart)) {
                        System.out.println("getDepartFrom pass");
                        this.getLocalArriveAt().click();
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    Constant.WEBDRIVER.navigate().refresh();
                    getDepartFrom();
                }
            } while (!flag);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void getArriveAt() {
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Select arriveAt = new Select(getCboArriveAt());
        List<WebElement> allArriveAt = arriveAt.getOptions();
        JSONObject jsonObject = null;
        try {
            jsonObject = callJSON("src/main/java/Constant/data.json", 0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject1 = (JSONObject) jsonObject.get("TC14");
        String localTest0 = (String) jsonObject1.get("Arrive at");
        String local0;
        boolean flag = false;
        {
            try {
                do {
                    for (int i = 0; i < allArriveAt.size(); i++) {
                        local0 = allArriveAt.get(i).getText();
                        if (local0.equals(localTest0)) {
                            WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 10);
                            wait.until(ExpectedConditions.visibilityOfElementLocated(localArriveAt)).click();
                            System.out.println("getArriveAt pass");
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        Constant.WEBDRIVER.navigate().refresh();
                        getDepartFrom();
                    }
                } while (flag == false);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public void getSeatType() throws IOException, ParseException {
        Select seatType = new Select(getCboSeatStyle());
        List<WebElement> allSeat = seatType.getOptions();
        JSONObject jsonObject = callJSON("src/main/java/Constant/data.json", 0);
        JSONObject jsonObject1 = (JSONObject) jsonObject.get("TC14");
        String seatTest = (String) jsonObject1.get("Seat type");
        try {
            for (int i = 0; i < allSeat.size(); i++) {
                String seat = allSeat.get(i).getText();
                if (seat.equals(seatTest)) {
                    WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 10);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(seatTypeSoftSeat)).click();
                    System.out.println("seat style pass");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void getTicketAmount() throws IOException, ParseException {
        Select ticketAmount = new Select(getCboTicketAmount());
        List<WebElement> allTicket = ticketAmount.getOptions();
        JSONObject jsonObject = callJSON("src/main/java/Constant/data.json", 0);
        JSONObject jsonObject1 = (JSONObject) jsonObject.get("TC14");
        String ticketTest = (String) jsonObject1.get("Ticket amount");
        try {
            for (int i = 0; i < allTicket.size(); i++) {

                String ticket = allTicket.get(i).getText();
                if (ticket.equals(ticketTest)) {
                    Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']/div/form//select[@name ='TicketAmount']//option[text()='5']")).click();

                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

