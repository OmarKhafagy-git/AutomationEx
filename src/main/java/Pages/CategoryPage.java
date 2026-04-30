package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryPage {
    WebDriver driver;
    public CategoryPage(WebDriver driver) {
        this.driver = driver;
    }


    By CatTxt = By.xpath("/html/body/section/div/div[2]/div[2]/div/h2");



    public String CatTxt(){
        return driver.findElement(CatTxt).getText();
    }

    public void selectCatByIndex (int index){
        int rowNum = 1 + index;
        String DynamicPath = String.format("//*[@id=\"accordian\"]/div[%d]/div[1]/h4/a/span/i",rowNum);
        driver.findElement(By.xpath(DynamicPath)).click();
    }

    public void  selectCat(int index){
        int rowNum = 1 + index;
        String DynamicPath = String.format("//*[@id=\"Men\"]/div/ul/li[%d]/a",rowNum);
        driver.findElement(By.xpath(DynamicPath)).click();

    }
}
