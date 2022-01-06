package Railway;
import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyTicketPage extends GeneralPage {
    String btnCancel = "//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/..//input[@value='Cancel']";

    public MyTicketPage() {
    }

    protected WebElement getBtnCancel(String id, String departStation, String arriveStation) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(this.btnCancel, id, departStation, arriveStation)));
    }

    public void getCancel(String id, String departStation, String arriveStation) {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 5000);
        wait.until(ExpectedConditions.elementToBeClickable(this.getBtnCancel(id, departStation, arriveStation))).click();
        Constant.WEBDRIVER.switchTo().alert().accept();
    }

    public boolean isCancelDisplay(String id, String departStation, String arriveStation) {
        try {
            return this.getBtnCancel(id, departStation, arriveStation).isDisplayed();
        } catch (Exception var5) {
            System.out.print(var5.getMessage());
            return false;
        }
    }
}
