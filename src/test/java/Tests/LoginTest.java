package Tests;

import Pages.BaseTest;
import Pages.HomePage;
import Pages.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    HomePage H ;
    SignUpPage S;



    @Test
    public void LoginTest()
    {
        H = new HomePage(driver);
        H.clickSignUpBtn1();
        S = new SignUpPage(driver);
        S.loginToAcc("mero_kh2011@yahoo.com","123123");
        String ActualHeader = H.getLoggedInAs();
        Assert.assertEquals("Logged in as "+ActualHeader, "Logged in as omar","Error");

    }






}
