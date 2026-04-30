package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPlaced {
    WebDriver driver;
    public OrderPlaced(WebDriver driver) {
        this.driver=driver;
    }

    By msgSuccess = By.xpath("//*[@id=\"form\"]/div/div/div/p");


    public String Confirmation (){
        return driver.findElement(msgSuccess).getText();
    }
}
