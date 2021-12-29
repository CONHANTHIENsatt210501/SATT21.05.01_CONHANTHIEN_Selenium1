package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class GeneralPage {
    //locator
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href = '/Account/Login.cshtml']");
    private final By tabBooktick = By.xpath("//div[@id='menu']//a[@href = '/Page/BookTicketPage.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href = '/Account/Logout']");
    private final By lblWelcomeMesage = By.xpath("//div[@class='account']/strong");
    private final By lblLogout = By.xpath("//div[@id='menu']//a/span[text()='Log out']");

    //Element
    protected WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getTabLogout() {

        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    protected WebElement getLblWelcomeMesage() {

        return Constant.WEBDRIVER.findElement(lblWelcomeMesage);
    }

    protected WebElement getTabBooktick() {
        return Constant.WEBDRIVER.findElement(tabBooktick);
    }

    protected WebElement getLblLogout() {return Constant.WEBDRIVER.findElement(lblLogout);}

    //Methods
    public String getWelcomeMesage() {
        return this.getLblWelcomeMesage().getText();
    }

    public void gotoLoginPage() {
        this.getTabLogin().click();
    }

    public boolean checkgoToLogoutPage(){
        try{
            if (getLblLogout().equals("Logout"))
            {
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            System.out.print(e);
        }

        return false;
    }

    public void gotoBookTickPage() {
        this.getTabBooktick().click();

    }

    public void goToLogoutPage(){
        this.getTabLogout().click();
    }
    public String goToLogoutPageSuccess(){
        String check;
        this.getTabLogout().click();
        if(checkgoToLogoutPage() == true){
            check = "Fail";
        }else{
            check = "Success";
        }
       return check;
    }

}