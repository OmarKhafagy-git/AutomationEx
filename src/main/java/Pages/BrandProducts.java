package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrandProducts {
    WebDriver driver;
    public BrandProducts(WebDriver driver) {
        this.driver = driver;
    }

    public void  selectBrandByIndex(int index){
        int rowNumber = 1 + index;
        String DynamicPath = String.format("/html/body/section/div/div[2]/div[1]/div/div[2]/div/ul/li[%d]/a", rowNumber);
        driver.findElement(By.xpath(DynamicPath)).click();
    }
}
