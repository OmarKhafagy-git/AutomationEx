package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    By Footer = By.xpath("//*[@id=\"footer\"]/div[2]");
    By SubEmail = By.xpath("//*[@id=\"susbscribe_email\"]");
    By SubBtn = By.xpath("//*[@id=\"subscribe\"]");
    By SubSuccess = By.xpath("//*[@id=\"success-subscribe\"]");
    By SubTxt = By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2");
    By Quantity = By.xpath("//*[@id=\"product-1\"]/td[4]/button");
    By CheckOut = By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a");
    By Reg_log = By.xpath("//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a/u");
    By RemoveProduct = By.xpath("//*[@id=\"product-1\"]/td[6]/a/i");
    By CartEmpty = By.xpath("//*[@id=\"cart_info\"]");
    By ProductInfo = By.xpath("//*[@id=\"cart_info_table\"]");

    public boolean isProductVisible() {
        return driver.findElement(ProductInfo).isDisplayed();
    }



    public int getNumberOfItemsInCart(){
        return driver.findElements(By.xpath("//tbody/tr")).size();
    }


    public boolean IsCartEmptyVisible() {
        return driver.findElement(CartEmpty).isDisplayed();
    }

    // Instead of the hardcoded Chrome XPath, use our dynamic row locator!
    public void removeProductByIndex(int javaIndex) {
        int rowNumber = javaIndex + 1;

        // This XPath looks for the "Delete" button based on the Row Number, not the Product ID!
        String dynamicXpath = String.format("//tbody/tr[%d]//a[@class='cart_quantity_delete']", rowNumber);

        driver.findElement(By.xpath(dynamicXpath)).click();
    }

    public void removeProduct() {
        driver.findElement(RemoveProduct).click();
    }


    public void Reg_logBtn(){
        driver.findElement(Reg_log).click();
    }



    public void CheckOutBtn(){
        driver.findElement(CheckOut).click();
    }



    public String getQuantity() {
        return driver.findElement(Quantity).getText();
    }



    public void ScrollToFooter(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(Footer));
    }

    public String getSubTxt() {
        return driver.findElement(SubTxt).getText();
    }

    public String Subscribe(String email) {
        driver.findElement(SubEmail).sendKeys(email);
        driver.findElement(SubBtn).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(SubSuccess)));
        return driver.findElement(SubSuccess).getText();
    }


    // 1. Get the Price by Row Number
    public String getProductPriceByRow(int rowNumber) {
        // We tell XPath to go to the specific row (e.g., tr[1]), then dive into the price column
        String Xpath = "//tbody/tr[%d]//td[@class='cart_price']/p";

        String dynamicXpath = String.format(Xpath, rowNumber);

        return driver.findElement(By.xpath(dynamicXpath)).getText();
    }

    // 2. Get the Quantity by Row Number
    public String getProductQuantityByRow(int rowNumber) {
        String Xpath = "//tbody/tr[%d]//td[@class='cart_quantity']/button";
        String dynamicXpath = String.format(Xpath, rowNumber);

        return driver.findElement(By.xpath(dynamicXpath)).getText();
    }

    // 3. Get the Total by Row Number
    public String getProductTotalByRow(int rowNumber) {
        String Xpath = "//tbody/tr[%d]//td[@class='cart_total']/p";
        String dynamicXpath = String.format(Xpath, rowNumber);

        return driver.findElement(By.xpath(dynamicXpath)).getText();
    }
}
