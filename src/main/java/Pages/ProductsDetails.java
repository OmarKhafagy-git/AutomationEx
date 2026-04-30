package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsDetails {
    WebDriver driver;
    public ProductsDetails(WebDriver driver) {
        this.driver = driver;
    }


    By ProductDetails = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div");
    By IncreaseQuan = By.xpath("//*[@id=\"quantity\"]");
    By AddToCart = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button");




    public void increaseQuantity(String quantity) {
        driver.findElement(IncreaseQuan).clear();
        driver.findElement(IncreaseQuan).sendKeys(quantity);
    }

    public void addToCart() {
        driver.findElement(AddToCart).click();
    }


    public boolean isProductDetailsDisplayed() {
        return driver.findElement(ProductDetails).isDisplayed();
    }
}
