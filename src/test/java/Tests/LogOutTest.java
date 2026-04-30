package Tests;

import Pages.BaseTest;
import Pages.HomePage;
import Pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogOutTest extends BaseTest {
    HomePage H;
    SignUpPage S;
    @Test
    public void LogOutTest()
    {
        H = new HomePage(driver);
        H.clickSignUpBtn1();
        S = new SignUpPage(driver);
        S.loginToAcc("mero_kh2011@yahoo.com","123123");
        H.LogOut();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://automationexercise.com/login");
    }
}
