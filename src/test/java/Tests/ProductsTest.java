package Tests;

import Pages.BaseTest;
import Pages.HomePage;
import Pages.ProductsDetails;
import Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProductsTest extends BaseTest {
    HomePage h ;
    ProductsPage p ;
    ProductsDetails pd;


@Test
    public void ProductsPageTest(){
      h = new HomePage(driver);
      h.ProductsBtn();
      String currentUrl = driver.getCurrentUrl();
      Assert.assertEquals(currentUrl,"https://automationexercise.com/products","Error: Did not reach the Test Cases page!");

      p = new ProductsPage(driver);
      p.View1stProductBtn();

      currentUrl = driver.getCurrentUrl();
      Assert.assertEquals(currentUrl,"https://automationexercise.com/product_details/1","Error: Did not reach the Product Details page!");

      SoftAssert softAssert = new SoftAssert();
      softAssert.assertTrue(pd.isProductDetailsDisplayed(),"Error: Product Details is not displayed!");

      softAssert.assertAll();

    }

}
