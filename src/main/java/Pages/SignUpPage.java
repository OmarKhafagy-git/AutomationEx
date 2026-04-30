package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SignUpPage {

    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;

    }

    //elements

    By NameField = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]");
    By EmailField = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]");
    By SignUpBtn2 = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button");
    By NewUserTxt = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2");
    By LoginToAcc = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2");
    By EmailLog = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]");
    By Password = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]");
    By LoginBtn = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button");


    public String getLoginToAcc() {
        return driver.findElement(LoginToAcc).getText();
    }

    public void loginToAcc(String email, String password) {
        driver.findElement(EmailLog).sendKeys(email);
        driver.findElement(Password).sendKeys(password);
        driver.findElement(LoginBtn).click();
    }


    public void initSignUp(String name, String email) {
        driver.findElement(NameField).sendKeys(name);
        driver.findElement(EmailField).sendKeys(email);
        driver.findElement(SignUpBtn2).click();

    }
    public String getNewUserTxt() {
        return driver.findElement(NewUserTxt).getText();
    }
}


















