package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    By View1stProduct = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a");
    //By ProductDetails = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div");
    By SearchTxt = By.xpath("//*[@id=\"search_product\"]");
    By SearchBtn = By.xpath("//*[@id=\"submit_search\"]/i");
    By RelatedProducts = By.xpath("/html/body/section[2]/div/div/div[2]/div");
    By Continue = By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button");
    By ViewCart = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u");
    By allAddButtons = By.xpath("//div[@class='productinfo text-center']//a[contains(@class, 'add-to-cart')]");
    By Brands = By.xpath("/html/body/section[2]/div/div/div[1]/div/div[2]");
    By BrandProducts = By.xpath("/html/body/section/div/div[2]/div[2]/div");





    public boolean isBrandProductVisible() {
        return driver.findElement(BrandProducts).isDisplayed();
    }

    public void selectBrandByIndex(int index){
        int rowNum = 1 + index;
        String DynamicPath = String.format("/html/body/section[2]/div/div/div[1]/div/div[2]/div/ul/li[%d]/a",rowNum);
        driver.findElement(By.xpath(DynamicPath)).click();
    }

    public boolean isBrandsVisible(){
        return driver.findElement(Brands).isDisplayed();
    }



    public void continueBtn() {
        driver.findElement(Continue).click();
    }

    public void viewCartBtn() {
        driver.findElement(ViewCart).click();
    }

    public void AddTOCart(int index)
    {
        List<WebElement> buttonsList = driver.findElements(allAddButtons);
        buttonsList.get(index).click();
    }


    public void searchProduct(String productName) {
        driver.findElement(SearchTxt).sendKeys(productName);
        driver.findElement(SearchBtn).click();
    }

    public boolean isRelatedProductsDisplayed(){
        return driver.findElement(RelatedProducts).isDisplayed();
    }


//    public boolean isProductDetailsDisplayed() {
//        return driver.findElement(ProductDetails).isDisplayed();
//    }

    public void View1stProductBtn() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", driver.findElement(View1stProduct));

    }
}
