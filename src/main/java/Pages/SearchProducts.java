package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchProducts {
    WebDriver driver;
    public SearchProducts(WebDriver driver) {
        this.driver = driver;
    }


    By SearchedTxt = By.xpath("/html/body/section[2]/div/div/div[2]/div/h2");
    By RelatedProducts = By.xpath("/html/body/section[2]/div/div/div[2]/div");
    By allAddButtons = By.xpath("//div[@class='productinfo text-center']//a[contains(@class, 'add-to-cart')]");


    // Ask Selenium to count how many products showed up in the search results
    public int getNumberOfProductsFound() {
        // We use findElements (plural) to grab the whole list, then just ask for its size!
        return driver.findElements(allAddButtons).size();
    }

    public void AddTOCart(int index)
    {
        List<WebElement> buttonsList = driver.findElements(allAddButtons);
        buttonsList.get(index).click();
    }


    public boolean isRelatedProductsDisplayed(){
        return driver.findElement(RelatedProducts).isDisplayed();

    }

    public String SearchedTxt()
    {
       return driver.findElement(SearchedTxt).getText();
    }
}
