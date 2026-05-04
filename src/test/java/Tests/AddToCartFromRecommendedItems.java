package Tests;

import Pages.BaseTest;
import Pages.CartPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartFromRecommendedItems extends BaseTest {
    HomePage h ;
    CartPage c ;



    @Test
    public void addToCartFromRecommendedItems()
    {
        h = new HomePage(driver);
        c = new CartPage(driver);

        h.ScrollToRecommendedProduct();

        String Header = h.getRecommendedTxt();
        Assert.assertEquals(Header,"RECOMMENDED ITEMS");

        h.SelectRecommendedItemByIndex(1);

        boolean isVisible = c.isProductVisible();
        Assert.assertTrue(isVisible);




    }
}
