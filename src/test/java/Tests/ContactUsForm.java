package Tests;

import Pages.BaseTest;
import Pages.ContactUs;
import Pages.HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ContactUsForm extends BaseTest {
    HomePage H;
    ContactUs C;



    @Test
    public void contactUsForm() throws InterruptedException {
        H = new HomePage(driver);
        boolean isVisible = H.isHomePageLogoVisible();
        Assert.assertTrue(isVisible,"logo is not visible");
        H.contactUsBtn();
        C = new ContactUs(driver);
        String actualTxt = C.GetInTouchTxt();
        Assert.assertEquals(actualTxt,"GET IN TOUCH","Text not found");
        C.fillTheForm("dad","fwf@sas","fsdf","fdsf");
        String projectPath = System.getProperty("user.dir");
        String DynamicPath = projectPath+"/src/test/resources/testData/scr1.png";
        C.uploadDocument(DynamicPath);

        C.acceptAlert();
        String actualTxt2 = C.getSuccessMsg();
        Assert.assertEquals(actualTxt2,"Success! Your details have been submitted successfully.");
        //destroyAnnoyingAds();

        C.homeBtn();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://automationexercise.com/"));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,"https://automationexercise.com/");


    }

}
