package Tests;

import Pages.BaseTest;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCasesNavigation extends BaseTest {
    HomePage h ;

    @Test
    public void TestCasesPage() {
        h = new HomePage(driver);
        h.isHomePageLogoVisible();
        h.TestCasesBtn();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://automationexercise.com/test_cases","Error: Did not reach the Test Cases page!");

    }

}
