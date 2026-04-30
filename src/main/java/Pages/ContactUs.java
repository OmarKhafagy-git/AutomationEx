package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUs {
    WebDriver driver;
    public ContactUs(WebDriver driver) {
        this.driver = driver;
    }



    By GetInTouch = By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/h2");
    By Name = By.xpath("//*[@id=\"contact-us-form\"]/div[1]/input");
    By Email = By.xpath("//*[@id=\"contact-us-form\"]/div[2]/input");
    By Subject = By.xpath("//*[@id=\"contact-us-form\"]/div[3]/input");
    By enterMsg = By.xpath("//*[@id=\"message\"]");
    By UploadFile =By.xpath("//*[@id=\"contact-us-form\"]/div[5]/input");
    By SubmitBtn = By.xpath("//*[@id=\"contact-us-form\"]/div[6]/input");
    By SuccessMsg = By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]");
    By HomeBtn = By.xpath("//*[@id=\"form-section\"]/a/span/i");


    public String getSuccessMsg() {
        return driver.findElement(SuccessMsg).getText();
    }

    public void homeBtn (){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement HomeButton = driver.findElement(HomeBtn);
        js.executeScript("arguments[0].click();", HomeButton);
    }


    public void uploadDocument(String absolutePath) {
        driver.findElement(UploadFile).sendKeys(absolutePath);
        driver.findElement(SubmitBtn).click();

    }

    public String GetInTouchTxt() {
        return driver.findElement(GetInTouch).getText();
    }

    public void fillTheForm(String name, String email, String subject, String msg){
        driver.findElement(Name).sendKeys(name);
        driver.findElement(Email).sendKeys(email);
        driver.findElement(Subject).sendKeys(subject);
        driver.findElement(enterMsg).sendKeys(msg);
    }

    public void acceptAlert(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

}
