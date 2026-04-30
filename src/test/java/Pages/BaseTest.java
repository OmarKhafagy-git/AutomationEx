package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class BaseTest {

    // CRITICAL: Make the driver 'protected' so child classes can see it!
    protected WebDriver driver;

    @BeforeMethod
    public void setupDriver() {
         ChromeOptions options = new ChromeOptions();
         options.addArguments("--disable-popup-blocking");
         options.addArguments("--disable-notifications");
         options.addArguments("--blink-settings=imagesEnabled=false");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

//    @AfterMethod
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

    public void destroyAnnoyingAds() {
        try {
            // 1. The "Vignette" URL Hack
            // Sometimes the ad changes the URL. This forcefully removes the ad from the URL.
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("#google_vignette")) {
                driver.get(currentUrl.replace("#google_vignette", ""));
            }

            // 2. The Iframe Annihilator
            // This tells the browser: "Find every iframe on the screen and delete it."
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.querySelectorAll('iframe').forEach(iframe => iframe.remove());");

        } catch (Exception e) {
            System.out.println("No ads found to destroy!");
        }
    }
}