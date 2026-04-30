package Tests;

import Pages.BaseTest;
import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddToCart extends BaseTest {
    HomePage h;
    ProductsPage p;
    CartPage c;



    @Test
    public void addToCart()
    {
        h = new HomePage(driver);
        boolean isVisible = h.isHomePageLogoVisible();
        Assert.assertTrue(isVisible,"Error: HomePage logo is not visible!");
        h.ProductsBtn();

        p = new ProductsPage(driver);
        p.AddTOCart(0);
        p.continueBtn();
        p.AddTOCart(1);
        p.viewCartBtn();

        c = new CartPage(driver);
        SoftAssert softAssert = new SoftAssert();

        String PriceTxt1 = c.getProductPriceByRow(1);
        String quantityTxt1 = c.getProductQuantityByRow(1);
        String totalTxt1 = c.getProductTotalByRow(1);

        softAssert.assertEquals(PriceTxt1,"Rs. 500","Error: Product Price is not correct!");
        softAssert.assertEquals(quantityTxt1,"1","Error: Product Quantity is not correct!");
        softAssert.assertEquals(totalTxt1,"Rs. 500","Error: Total Price is not correct!");

        // Grab the raw text from the second item in the cart
        String priceText2 = c.getProductPriceByRow(2);
        String quantityText2 =  c.getProductQuantityByRow(2);
        String totalText2 = c.getProductTotalByRow(2);

        // Basic Text Assertions (Assuming the second item is Rs. 400)
        softAssert.assertEquals(priceText2, "Rs. 400", "Index 1: Price mismatch!");
        softAssert.assertEquals(quantityText2, "1", "Index 1: Quantity mismatch!");
        softAssert.assertEquals(totalText2, "Rs. 400", "Index 1: Total text mismatch!");



        softAssert.assertAll();





    }
}
