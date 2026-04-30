package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
    WebDriver driver;
    public CheckOutPage(WebDriver driver)
        {
        this.driver=driver;
        }

        By addressDetails = By.xpath("//*[@id=\"cart_items\"]/div/div[3]");
        By reviewOrder = By.xpath("//*[@id=\"cart_info\"]");
        By comment = By.xpath("//*[@id=\"ordermsg\"]/textarea");
        By PlaceOrder = By.xpath("//*[@id=\"cart_items\"]/div/div[7]/a");


        public void PlaceOrderBTN()
        {
            driver.findElement(PlaceOrder).click();
        }

         public boolean isAddDetailsVisible(){
             return driver.findElement(addressDetails).isDisplayed();
         }


         public boolean isReviewOrderVisible(){
             return driver.findElement(reviewOrder).isDisplayed();
         }

         public void Comment(String Comment){
             driver.findElement(comment).sendKeys(Comment);
         }







}

