package Tests;

import Pages.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyProductQuanInCart extends BaseTest {

    HomePage h ;
    ProductsDetails p ;
    ProductsPage P;
    CartPage c ;


    @Test
    public void verifyProductQuantityInCart()
    {
        h = new HomePage(driver);
        boolean IsVisible = h.isHomePageLogoVisible();
        Assert.assertTrue(IsVisible);
        h.ViewProductBtn();

        p = new ProductsDetails(driver);
        IsVisible = p.isProductDetailsDisplayed();
        Assert.assertTrue(IsVisible);

        p.increaseQuantity("4");
        p.addToCart();

        P = new ProductsPage(driver);
        P.viewCartBtn();

        c = new CartPage(driver);
        String Quantity = c.getQuantity();
        Assert.assertEquals(Quantity, "4");


    }
}
