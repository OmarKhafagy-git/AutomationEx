package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage {
    WebDriver driver;
    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
    }


    By AccountCreated = By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");
    By ContinueBtn = By.xpath("//*[@id=\"form\"]/div/div/div/div/a");

    public String getAccountCreatedTxt(){
        return driver.findElement(AccountCreated).getText();
    }

    public void clickContinueBtn()
    {
        driver.findElement(ContinueBtn).click();
    }


}