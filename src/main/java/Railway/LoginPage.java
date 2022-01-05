package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginPage extends GeneralPage {


    //locator
    private final By txtUsername = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.xpath("//input[@value='Login']");
    private final By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");


    //Element
    protected WebElement getTxtUsername() {
        return Constant.WEBDRIVER.findElement(txtUsername);
    }


    protected WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    protected WebElement getBtnLogin() {
        return Constant.WEBDRIVER.findElement(btnLogin);
    }

    protected WebElement getLblLoginErrorMsg() {
        return Constant.WEBDRIVER.findElement(lblLoginErrorMsg);
    }


    //Methods
    public void Login(String name, String password) {
        //Submit login
        this.getTxtUsername().sendKeys(name);
        this.getTxtPassword().sendKeys(password);
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        this.getBtnLogin().click();
    }

    //Message error Login
    public String getLoginErrorMsg() {
        return this.getLblLoginErrorMsg().getText();
    }


    //Method login MutilTime
    public void LoginMutilTime(String name, String password, int time) {
        int count = 1;
        do {
            this.getTxtUsername().sendKeys(name);
            this.getTxtPassword().sendKeys(password);
            this.getBtnLogin().click();
            count++;
        } while (count < time);
    }

}
