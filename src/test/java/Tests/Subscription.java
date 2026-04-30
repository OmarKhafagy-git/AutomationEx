package Tests;

import Pages.BaseTest;
import Pages.CartPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Subscription extends BaseTest {

    HomePage h ;
    CartPage C ;


    @Test
    public void subscriptionTest()
    {
        h = new HomePage(driver);
        boolean isVisible = h.isHomePageLogoVisible();
        Assert.assertTrue(isVisible,"logo is not visible");

        h.ScrollToFooter();

        String subTxt = h.getSubTxt();
        Assert.assertEquals(subTxt,"SUBSCRIPTION");

        subTxt = h.Subscribe("dsds@ds");
        Assert.assertEquals(subTxt,"You have been successfully subscribed!");


    }

    @Test
    public void subscriptionTest2()
    {
        h = new HomePage(driver);
        boolean isVisible = h.isHomePageLogoVisible();
        Assert.assertTrue(isVisible,"logo is not visible");
        h.CartBTN();
        C = new CartPage(driver);
        String subTxt = C.getSubTxt();
        Assert.assertEquals(subTxt,"SUBSCRIPTION");
        subTxt = C.Subscribe("dsds@ds");
        Assert.assertEquals(subTxt,"You have been successfully subscribed!");

    }
}
