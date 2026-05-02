package Tests;

import Pages.BaseTest;
import Pages.HomePage;
import Pages.ProductsDetails;
import Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddReviewOnProduct extends BaseTest {
    HomePage h;
    ProductsPage p;
    ProductsDetails pd;


    @Test
    public void addReviewOnProduct()
    {
        h = new HomePage(driver);
        p = new ProductsPage(driver);
        pd = new ProductsDetails(driver);

        h.ProductsBtn();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://automationexercise.com/products");

        p.View1stProductBtn();

        boolean isVisible = pd.isWriteReviewVisible();
        Assert.assertTrue(isVisible);

        pd.addReview("omar","aaa@ass","yes sir ");

        String successMsg = pd.SuccessMsg();
        Assert.assertEquals(successMsg, "Thank you for your review.");
    }

}
