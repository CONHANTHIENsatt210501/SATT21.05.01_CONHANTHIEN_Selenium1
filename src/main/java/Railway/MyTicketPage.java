package Railway;

import Constant.Constant;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyTicketPage extends GeneralPage {

    //Locator
    private final By tabMyTicket = By.xpath("//div[@id='menu']//a[@href = '/Page/ManageTicket.cshtml']");
    private final By dataTable = By.xpath(".//table/tbody");
    private final By headerRowLocator = By.xpath(".//tr[position()=1]");
    private final By dataRowsLocator = By.tagName("tr");
 //   private final By btnCancel = By.xpath("//*[@id=\"content\"]/form/div/div/table/tbody/tr[4]/td[11]/input");
    //Dynamic locators


    //Element
//    protected WebElement getBtnCancel() {
//        return Constant.WEBDRIVER.findElement(btnCancel);
//    }

    protected WebElement getDataTableLocator() {
        return Constant.WEBDRIVER.findElement(dataTable);
    }

    protected WebElement getHeaderRowLocator() {
        return Constant.WEBDRIVER.findElement(headerRowLocator);
    }

    protected List<WebElement> getDataRowsLocator() {
        return Constant.WEBDRIVER.findElements(dataRowsLocator);
    }

    protected WebElement getTabMyTicket() {
        return Constant.WEBDRIVER.findElement(tabMyTicket);
    }

    //Methods
    public void gotoMyTicket() {
        this.getTabMyTicket().click();
    }

    public void deleteTicket(int index) {
        int row_count = getDataRowsLocator().size();
        try {
            for (int i = 1; i <= row_count; i++) {
                if (i == index) {
                    WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 3000);
                    By xpathBtnCancel = By.xpath(String.format("//*[@id='content']/form/div/div/table/tbody/tr[%d]/td[11]/input[@type='button']", i));
                    WebElement btnCancel = Constant.WEBDRIVER.findElement(xpathBtnCancel);
                    wait.until(ExpectedConditions.elementToBeClickable(btnCancel));
                    new Actions(Constant.WEBDRIVER).moveToElement(btnCancel).click().perform();
                    Constant.WEBDRIVER.switchTo().alert().accept();
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
