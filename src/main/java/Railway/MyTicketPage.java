package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyTicketPage extends GeneralPage{

    //Locator
    private final By tabMyTicket = By.xpath("//div[@id='menu']//a[@href = '/Page/ManageTicket.cshtml']");
    private  final By dataTable = By.xpath(".//table/tbody");
    private  final By headerRowLocator = By.xpath(".//tr[position()=1]");
    private  final By dataRowsLocator = By.xpath(".//tr[not(position()=1)]");
    //Dynamic locators


    //Element
    protected List<WebElement> getDataTableLocator(){
        return (List<WebElement>) Constant.WEBDRIVER.findElement(dataTable);
    }

    protected  List<WebElement>getHeaderRowLocator(){
        return  (List<WebElement>)Constant.WEBDRIVER.findElement(headerRowLocator);
    }

    protected List<WebElement> getDataRowsLocator(){
        return (List<WebElement>) Constant.WEBDRIVER.findElement(dataRowsLocator);
    }

    protected WebElement getTabMyTicket(){
        return Constant.WEBDRIVER.findElement(tabMyTicket);
    }

    //Methods
    public void gotoMyTicket(){
        this.getTabMyTicket().click();
    }

   public void deleteTicket(int index){
        int count_row = getDataRowsLocator().size();
       for (int i = 0; i < count_row; i++) {
           if(i == index){
               WebElement row_index = getHeaderRowLocator().get(i);
               row_index.findElement(By.xpath(""))
           }
       }
   }

}
