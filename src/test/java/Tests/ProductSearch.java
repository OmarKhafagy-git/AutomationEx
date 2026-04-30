package Tests;

import Pages.BaseTest;
import Pages.HomePage;
import Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProductSearch extends BaseTest {
    HomePage h ;
    ProductsPage p ;


    @Test
    public void searchProducts(){
        h = new HomePage(driver);
        h.isHomePageLogoVisible();
        h.ProductsBtn();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://automationexercise.com/products");

        p = new ProductsPage(driver);
        p.searchProduct("Tshirt");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(p.isRelatedProductsDisplayed());

    }

}
