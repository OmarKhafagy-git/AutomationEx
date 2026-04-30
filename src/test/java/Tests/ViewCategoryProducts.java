package Tests;

import Pages.BaseTest;
import Pages.CategoryPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViewCategoryProducts extends BaseTest {
    HomePage h;
    CategoryPage c;


    @Test
    public void viewCategoryProducts(){
        h = new HomePage(driver);
        c = new CategoryPage(driver);

        boolean isVisible = h.isCategoryDisplayed();
        Assert.assertTrue(isVisible);

        h.selectCatByIndex(0);
        h.selectCategory(0);

        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "https://automationexercise.com/category_products/1");

        String header = c.CatTxt();
        Assert.assertEquals(header, "WOMEN - DRESS PRODUCTS");

        c.selectCatByIndex(1);
        c.selectCat(0);

        currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "https://automationexercise.com/category_products/3");




    }


}
