package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentPage {
    WebDriver driver;
    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }


    By NameOnCard = By.xpath("//*[@id=\"payment-form\"]/div[1]/div/input");
    By CardNum = By.xpath("//*[@id=\"payment-form\"]/div[2]/div/input");
    By CVC = By.xpath("//*[@id=\"payment-form\"]/div[3]/div[1]/input");
    By month = By.xpath("//*[@id=\"payment-form\"]/div[3]/div[2]/input");
    By year = By.xpath("//*[@id=\"payment-form\"]/div[3]/div[3]/input");
    By Confirm = By.xpath("//*[@id=\"submit\"]");
    By successOrder = By.xpath("//*[@id=\"success_message\"]/div");


    public void FillPaymentForm(String nameOnCard, String cardNum, String cvc, String ExpireMonth, String ExpireYear)
    {
        driver.findElement(NameOnCard).sendKeys(nameOnCard);
        driver.findElement(CardNum).sendKeys(cardNum);
        driver.findElement(CVC).sendKeys(cvc);
        driver.findElement(month).sendKeys(ExpireMonth);
        driver.findElement(year).sendKeys(ExpireYear);
        driver.findElement(Confirm).click();
    }

    public String SuccessMessage()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(successOrder));

        return messageElement.getText();
    }



}
