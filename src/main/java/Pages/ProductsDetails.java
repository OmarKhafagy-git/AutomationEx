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
    By WriteReviewTxd = By.xpath("/html/body/section/div/div/div[2]/div[3]/div[1]/ul/li/a");
    By Name = By.xpath("//*[@id=\"name\"]");
    By Email = By.xpath("//*[@id=\"email\"]");
    By AddReview = By.xpath("//*[@id=\"review\"]");
    By Submit = By.xpath("//*[@id=\"button-review\"]");
    By successMsg = By.xpath("//*[@id=\"review-section\"]/div/div/span");





    public String SuccessMsg() {
        return driver.findElement(successMsg).getText();

    }


    public boolean isWriteReviewVisible() {
        return driver.findElement(WriteReviewTxd).isDisplayed();
    }

    public void addReview(String name, String email, String review) {
        driver.findElement(Name).sendKeys(name);
        driver.findElement(Email).sendKeys(email);
        driver.findElement(AddReview).sendKeys(review);
        driver.findElement(Submit).click();
    }




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
