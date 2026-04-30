package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductAndVerifyCartAfterLogin extends BaseTest {
    HomePage h;
    ProductsPage p;
    SearchProducts sp;
    CartPage c;
    SignUpPage su;



    @Test
    public void searchProductAndVerifyCartAfterLogin() {
        h = new HomePage(driver);
        p = new ProductsPage(driver);
        sp = new SearchProducts(driver);
        c = new CartPage(driver);
        su = new SignUpPage(driver);

        h.ProductsBtn();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://automationexercise.com/products");

        p.searchProduct("Tshirt");

        boolean isVisible = sp.isRelatedProductsDisplayed();
        Assert.assertTrue(isVisible);

        int totalProducts = sp.getNumberOfProductsFound();

        for (int i = 0; i < totalProducts; i++) {
            sp.AddTOCart(i);
            p.continueBtn();
        }

        h.CartBTN();

        Assert.assertEquals(c.getNumberOfItemsInCart(), totalProducts);

        h.clickSignUpBtn1();

        su.loginToAcc("omar.2@g2ail.com","123456");
        h.CartBTN();


        Assert.assertEquals(c.getNumberOfItemsInCart(), totalProducts);













    }
}
