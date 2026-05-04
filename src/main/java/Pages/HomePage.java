package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    protected WebDriver driver;



    public HomePage(WebDriver driver) {
        this.driver = driver;
    }



    By SignUpBtn1 = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    By LoggedInAs = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b");
    By DeleteBtn = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
    By LogOutBtn = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    By Logo = By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img");
    By ContactUs = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a");
    By TestCases = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
    By Products = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a");
    By Footer = By.xpath("//*[@id=\"footer\"]/div[2]");
    By SubTxt = By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2");
    By SubEmail = By.xpath("//*[@id=\"susbscribe_email\"]");
    By SubBtn = By.xpath("//*[@id=\"subscribe\"]");
    By SubSucces = By.xpath("//*[@id=\"success-subscribe\"]");
    By Cart = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a");
    By ViewProduct = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[2]/ul/li/a");
    //By addProduct = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/a");
    By Continue = By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button");
    By allAddButtons = By.xpath("//div[@class='productinfo text-center']//a[contains(@class, 'add-to-cart')]");
    By Category = By.xpath("/html/body/section[2]/div/div/div[1]/div/h2");
    By RecommendedItems = By.xpath("/html/body/section[2]/div/div/div[2]/div[2]/h2");
    By ViewCart = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u");


    public String getRecommendedTxt(){
        return driver.findElement(RecommendedItems).getText();
    }

    public void SelectRecommendedItemByIndex(int index) {
        int rowNum = index + 1;
        String DynamicPath = String.format("//*[@id=\"recommended-item-carousel\"]/div/div[1]/div[%d]/div/div/div/a", rowNum);
        driver.findElement(By.xpath(DynamicPath)).click();
        driver.findElement(ViewCart).click();
    }

    public void selectCategory(int index){
        int rowNumber = 1 + index;
        String DynamicPath = String.format("//*[@id=\"Women\"]/div/ul/li[%d]/a",rowNumber);
        driver.findElement(By.xpath(DynamicPath)).click();
    }


    public void selectCatByIndex(int index){
        int rowNumber = index + 1;
        String DynamicPath = String.format("//*[@id=\"accordian\"]/div[%d]/div[1]/h4/a/span/i",rowNumber);
        driver.findElement(By.xpath(DynamicPath)).click();
    }

    public boolean isCategoryDisplayed() {
        return driver.findElement(Category).isDisplayed();
    }


    public boolean isHomePageLogoVisible() {
        return driver.findElement(Logo).isDisplayed();
    }


    public void ContinueBtn() {

        driver.findElement(Continue).click();
    }

    public void AddTOCart(int index)
    {
        List<WebElement> buttonsList = driver.findElements(allAddButtons);
        buttonsList.get(index).click();
    }


    public void ViewProductBtn() {
        driver.findElement(ViewProduct).click();
    }

    public void CartBTN() {
        driver.findElement(Cart).click();
    }

    public String Subscribe(String email) {
        driver.findElement(SubEmail).sendKeys(email);
        driver.findElement(SubBtn).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(SubSucces)));
        return driver.findElement(SubSucces).getText();
    }

    public String getSubTxt() {
        return driver.findElement(SubTxt).getText();
    }

    public void ScrollToRecommendedProduct() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(RecommendedItems));
    }

    public void ScrollToFooter() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(Footer));
    }


    public void TestCasesBtn () {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement HomeButton = driver.findElement(TestCases);
        js.executeScript("arguments[0].click();", HomeButton);
    }

    public void ProductsBtn () {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement HomeButton = driver.findElement(Products);
        js.executeScript("arguments[0].click();", HomeButton);
    }




    public void contactUsBtn(){
        driver.findElement(ContactUs).click();
    }

    public void  LogOut()
    {
        driver.findElement(LogOutBtn).click();
    }

    public void clickSignUpBtn1() {
        driver.findElement(SignUpBtn1).click();
    }

    public void deleteAccount() {
        driver.findElement(DeleteBtn).click();
    }

    public String getLoggedInAs(){
        return driver.findElement(LoggedInAs).getText();
    }

}
