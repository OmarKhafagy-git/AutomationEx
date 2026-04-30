package Tests;

import Pages.BaseTest;
import Pages.BrandProducts;
import Pages.HomePage;
import Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;

public class ViewBrandProducts extends BaseTest {
    HomePage h;
    ProductsPage p;
    BrandProducts bp;


    @Test
    public void viewBrandProducts()
    {
        h = new HomePage(driver);
        p = new ProductsPage(driver);
        bp = new BrandProducts(driver);

        h.ProductsBtn();
        boolean isVisible = p.isBrandsVisible();
        Assert.assertTrue(isVisible);

        p.selectBrandByIndex(0);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://automationexercise.com/brand_products/Polo");

        bp.selectBrandByIndex(1);
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://automationexercise.com/brand_products/H&M");
    }

}
