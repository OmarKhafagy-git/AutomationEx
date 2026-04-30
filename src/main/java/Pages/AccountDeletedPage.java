package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDeletedPage {
    WebDriver driver;
    public AccountDeletedPage(WebDriver driver) {
        this.driver = driver;
    }


    By AccountDelete = By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");
    By ContinueBtn = By.xpath("//*[@id=\"form\"]/div/div/div/div/a");

    public void contiue (){
        driver.findElement(ContinueBtn).click();
    }

    public String getAccountDeleteTxt() {
        return driver.findElement(AccountDelete).getText();
    }


}
