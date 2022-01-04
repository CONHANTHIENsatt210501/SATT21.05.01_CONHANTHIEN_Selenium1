package Railway;

import Constant.Constant;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.util.List;


public class TimetablePage extends GeneralPage {
    //selector
    private final By tabTimetable = By.xpath("//div[@id='menu']//a[@href ='TrainTimeListPage.cshtml']");
    private final By lblMessage = By.xpath("//tr[@class='TableSmallHeader']");
    private final By dblrow = By.xpath("//td[text()='Đà Nẵng']/following-sibling::td[text()='Sài Gòn']/../td");

    //element
    protected WebElement getDblrow (){return Constant.WEBDRIVER.findElement(dblrow);}

    protected WebElement getTabTimetable() {
        return Constant.WEBDRIVER.findElement(tabTimetable);
    }

    protected WebElement getlblMessage(){
        return Constant.WEBDRIVER.findElement(lblMessage);
    }

    //methods
    public String getDblRow(){
        return this.getDblrow().getText();
    }

    public String getLblMessage(){
        return this.getlblMessage().getText();
    }

    public void gotoTabTimeTable() {
        this.getTabTimetable().click();
    }

    public void getCheckpriceTable() throws IOException, ParseException {
        JSONObject head = callJSON("src/main/java/Constant/data.json", 0);
        JSONObject TC = (JSONObject) head.get("TC15");
        String depart = (String) TC.get("Depart Station");
        String arriveAt = (String) TC.get("Arrive Station");


        try {

            for (int i = 0; i < rows.size(); i++) {
                System.out.println(rows.get(i).getText());
            }
            System.out.println("");
//            if (LocalDepartStation.equals(depart) && LocalArriveStation.equals(arriveAt)) {
//                String xpath = "//td[count(//th[text()='Check Price']/preceding-sibling::th)+1]";
//                String xpath2 = //td[text()='Đà Nẵng']/following-sibling::td[text()='Sài Gòn']/..
//                String xpath1 = "//td[text()='Đà Nẵng']/following-sibling::td[text()='Sài Gòn']/..";
//                By checkprice = By.xpath(xpath2);
//                System.out.println(checkprice);
//                Constant.WEBDRIVER.findElement(checkprice).click();
//            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


}
