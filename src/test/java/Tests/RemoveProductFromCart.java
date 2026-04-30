package Tests;

import Pages.BaseTest;
import Pages.CartPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveProductFromCart extends BaseTest {
    HomePage h;
    CartPage c;


    @Test
    public void removeProductFromCart() throws InterruptedException {
        h=new HomePage(driver);
        boolean isVisible = h.isHomePageLogoVisible();
        Assert.assertTrue(isVisible);
        h.AddTOCart(1);
        h.ContinueBtn();
        h.CartBTN();
        c=new CartPage(driver);
        String currentUrl=driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://automationexercise.com/view_cart","Wrong url");
        c.removeProductByIndex(0);
        isVisible = c.IsCartEmptyVisible();
        Assert.assertTrue(isVisible);

    }

}
