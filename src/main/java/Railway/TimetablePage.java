package Railway;

import Constant.Constant;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.IOException;


public class TimetablePage extends GeneralPage {
    //selector
    private final By tabTimetable = By.xpath("//div[@id='menu']//a[@href ='TrainTimeListPage.cshtml']");
    private final By lblMessage = By.xpath("//tr[@class='TableSmallHeader']");

    //element
    protected WebElement getTabTimetable() {
        return Constant.WEBDRIVER.findElement(tabTimetable);
    }

    protected WebElement getlblMessage(){
        return Constant.WEBDRIVER.findElement(lblMessage);
    }

    //methods
    public String getLblMessage(){
        return this.getlblMessage().getText();
    }

    public void gotoTabTimeTable() {
        this.getTabTimetable().click();
    }

    public void getCheckpriceTable() throws IOException, ParseException {
        JSONObject head = callJSON("src/main/java/Constant/data.json", 0);
        JSONObject TC = (JSONObject) head.get("TC15");
        String Depart = (String) TC.get("Depart Station");
        try {
            By localDepartStation = By.xpath("//td[count(//th[text()='Depart Station']/preceding-sibling::th)+1][text()='Đà Nẵng']");
            String LocalDepartStation = Constant.WEBDRIVER.findElement(localDepartStation).getText();
            By localArriveStation = By.xpath("//td[count(//th[text()='Arrive Station']/preceding-sibling::th)+1][text()='Sài Gòn']");
            String LocalArriveStation = Constant.WEBDRIVER.findElement(localArriveStation).getText();
            if (LocalDepartStation.equals("Đà Nẵng") && LocalArriveStation.equals("Sài Gòn")) {
                String xpath = "//td[count(//th[text()='Check Price']/preceding-sibling::th)+1]";
                By checkprice = By.xpath(xpath);
                System.out.println(checkprice);
                Constant.WEBDRIVER.findElement(checkprice).click();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


}
