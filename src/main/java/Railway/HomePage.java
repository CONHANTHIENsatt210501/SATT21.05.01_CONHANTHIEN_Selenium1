package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends GeneralPage {

    //Localtor
    private final By tabHome = By.xpath("//div[@id='menu']//li[@class = 'selected']//a[@href='../']");

    //Elements
    protected WebElement getTabHome(){
        return Constant.WEBDRIVER.findElement(tabHome);
    }

    //Methods


    public HomePage open() {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
        return this;
    }

    public void gotoHomepage(){
        this.getTabHome().click();
    }

}
