package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceOrder extends BaseTest {
    HomePage H ;
    CartPage C;
    CheckOutPage CO ;
    PaymentPage P;
    SignUpPage SU;
    AccountInfo AI;
    AccountCreatedPage AC;
    AccountDeletedPage AD;
    OrderPlaced OP;




    @Test
    public void RegisterWhileCheckOut() throws InterruptedException {
        H = new HomePage(driver);
        boolean isVisible = H.isHomePageLogoVisible();
        Assert.assertTrue(isVisible);

        H.AddTOCart(1);
        H.ContinueBtn();
        H.CartBTN();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://automationexercise.com/view_cart");

        C=new CartPage(driver);
        C.CheckOutBtn();
        C.Reg_logBtn();

        SU=new SignUpPage(driver);
        SU.initSignUp("omar","omaesskar@aaa");

        AI=new AccountInfo(driver);
        AI.FillingSignUp("123","omar","kh","ada","Canada","siu","mia","2311","012","24","July","2000");

        AC=new AccountCreatedPage(driver);

        String actualHeader = AC.getAccountCreatedTxt();
        Assert.assertEquals(actualHeader, "ACCOUNT CREATED!");

        AC.clickContinueBtn();

        actualHeader = H.getLoggedInAs();
        Assert.assertEquals(actualHeader, "omar");

        H.CartBTN();
        C.CheckOutBtn();

        CO=new CheckOutPage(driver);
        isVisible = CO.isAddDetailsVisible();
        Assert.assertTrue(isVisible);
        isVisible = CO.isReviewOrderVisible();
        Assert.assertTrue(isVisible);

        CO.Comment("i am okkkk");
        CO.PlaceOrderBTN();

        P=new PaymentPage(driver);
        P.FillPaymentForm("omar","123456","334","6","2029");

        OP=new OrderPlaced(driver);
        actualHeader = OP.Confirmation();
        Assert.assertEquals(actualHeader, "Congratulations! Your order has been confirmed!");

        H.deleteAccount();

        AD=new AccountDeletedPage(driver);

        actualHeader = AD.getAccountDeleteTxt();
        Assert.assertEquals(actualHeader, "ACCOUNT DELETED!");

    }

    @Test
    public void RegisterBeforeCheckOut() throws InterruptedException {
        H = new HomePage(driver);
        boolean isVisible = H.isHomePageLogoVisible();
        Assert.assertTrue(isVisible);
        H.clickSignUpBtn1();
        SU=new SignUpPage(driver);
        SU.initSignUp("omar","teest@aaa");
        AI=new AccountInfo(driver);
        AI.FillingSignUp("123","omar","kh","ada","Canada","siu","mia","2311","012","24","July","2000");
        AC=new AccountCreatedPage(driver);
        String actualHeader = AC.getAccountCreatedTxt();
        Assert.assertEquals(actualHeader, "ACCOUNT CREATED!");
        AC.clickContinueBtn();
        actualHeader = H.getLoggedInAs();
        Assert.assertEquals(actualHeader, "omar");
        H.AddTOCart(1);
        H.ContinueBtn();
        H.CartBTN();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://automationexercise.com/view_cart");
        C=new CartPage(driver);
        C.CheckOutBtn();
        CO=new CheckOutPage(driver);
        isVisible = CO.isAddDetailsVisible();
        Assert.assertTrue(isVisible);
        isVisible = CO.isReviewOrderVisible();
        Assert.assertTrue(isVisible);
        CO.Comment("i am okkkk");
        CO.PlaceOrderBTN();
        P=new PaymentPage(driver);
        P.FillPaymentForm("omar","123456","334","6","2029");
        OP=new OrderPlaced(driver);
        actualHeader = OP.Confirmation();
        Assert.assertEquals(actualHeader, "Congratulations! Your order has been confirmed!");
//        H.deleteAccount();
//        AD=new AccountDeletedPage(driver);
//        actualHeader = AD.getAccountDeleteTxt();
//        Assert.assertEquals(actualHeader, "ACCOUNT DELETED!");

    }

    @Test
    public void LoginBeforeCheckOut() throws InterruptedException {
        H = new HomePage(driver);
        boolean isVisible = H.isHomePageLogoVisible();
        Assert.assertTrue(isVisible);
        H.clickSignUpBtn1();
        SU=new SignUpPage(driver);
        SU.loginToAcc("test@aaa","123");
        String actualHeader = H.getLoggedInAs();
        Assert.assertEquals(actualHeader, "omar");
        H.AddTOCart(0);
        H.ContinueBtn();
        H.CartBTN();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://automationexercise.com/view_cart");
        C=new CartPage(driver);
        C.CheckOutBtn();
        CO=new CheckOutPage(driver);
        isVisible = CO.isAddDetailsVisible();
        Assert.assertTrue(isVisible);
        isVisible = CO.isReviewOrderVisible();
        Assert.assertTrue(isVisible);
        CO.Comment("i am okkkk");
        CO.PlaceOrderBTN();
        P=new PaymentPage(driver);
        P.FillPaymentForm("omar","123456","334","6","2029");
        OP=new OrderPlaced(driver);
        actualHeader = OP.Confirmation();
        Assert.assertEquals(actualHeader, "Congratulations! Your order has been confirmed!");
        H.deleteAccount();
        AD=new AccountDeletedPage(driver);
        actualHeader = AD.getAccountDeleteTxt();
        Assert.assertEquals(actualHeader, "ACCOUNT DELETED!");

    }
}
