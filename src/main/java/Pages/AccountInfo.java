package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AccountInfo {
    WebDriver driver;
    public AccountInfo(WebDriver driver) {
        this.driver = driver;
    }

    By GenderBtn = By.id("id_gender1");
    By Password = By.xpath("//*[@id=\"password\"]");
    By Day = By.xpath("//*[@id=\"days\"]");
    By Month = By.xpath("//*[@id=\"months\"]");
    By Year = By.xpath("//*[@id=\"years\"]");
    By NewsletterCheckBox = By.id("newsletter");
    By SpecialOferCheckBox = By.id("optin");
    By FirstName = By.xpath("//*[@id=\"first_name\"]");
    By LastName = By.xpath("//*[@id=\"last_name\"]");
    By Address = By.xpath("//*[@id=\"address1\"]");
    By Country = By.xpath("//*[@id=\"country\"]");
    By State = By.xpath("//*[@id=\"state\"]");
    By City = By.xpath("//*[@id=\"city\"]");
    By Zipcode = By.xpath("//*[@id=\"zipcode\"]");
    By MobileNumber = By.xpath("//*[@id=\"mobile_number\"]");
    By CreateAccountBtn = By.xpath("//*[@id=\"form\"]/div/div/div/div/form/button");
    By EnterAccInfoTxt = By.xpath("//*[@id=\"form\"]/div/div/div/div/h2/b");




    public void FillingSignUp (String password,String firstName, String lastName, String address, String country, String state, String city, String zipcode, String mobileNumber,String day,String month,String year) throws InterruptedException {
        driver.findElement(GenderBtn).click();
        driver.findElement(Password).sendKeys(password);
        Select DayOfBirth = new Select(driver.findElement(Day));
        DayOfBirth.selectByValue(day);
        Select MonthOfBirth = new Select(driver.findElement(Month));
        MonthOfBirth.selectByVisibleText(month);
        Select YearOfBirth = new Select(driver.findElement(Year));
        YearOfBirth.selectByValue(year);
        driver.findElement(NewsletterCheckBox).click();
        driver.findElement(SpecialOferCheckBox).click();
        driver.findElement(FirstName).sendKeys(firstName);
        driver.findElement(LastName).sendKeys(lastName);
        driver.findElement(Address).sendKeys(address);
        Select CountryName = new Select(driver.findElement(Country));
        CountryName.selectByVisibleText(country);
        driver.findElement(State).sendKeys(state);
        driver.findElement(City).sendKeys(city);
        driver.findElement(Zipcode).sendKeys(zipcode);
        driver.findElement(MobileNumber).sendKeys(mobileNumber);
        Thread.sleep(2000);
        driver.findElement(CreateAccountBtn).click();
    }

    public String getEnterAccInfoTxt() {
        return driver.findElement(EnterAccInfoTxt).getText();
    }



}
