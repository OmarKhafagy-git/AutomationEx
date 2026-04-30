package Tests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {
  SignUpPage sU;
  HomePage h;
  AccountInfo AI;
  AccountCreatedPage AC;
  AccountDeletedPage AD;




  @Test
  public void SignUpInitializationTest() throws InterruptedException {
    h = new HomePage(driver);
    h.clickSignUpBtn1();
    sU = new SignUpPage(driver);
    String ActualHeader = sU.getNewUserTxt();
    Assert.assertEquals(ActualHeader, "New User Signup!","Error");
    sU.initSignUp("Omar","omar.2@g2ail.com");

    // Thread.sleep(1000);
    AI = new AccountInfo(driver);
    String ActualHeader2 = AI.getEnterAccInfoTxt();
    Assert.assertEquals(ActualHeader2, "ENTER ACCOUNT INFORMATION","Error");
    AI.FillingSignUp("123456","omar","kh","meno","Canada","united","siu","1213","1234554",
          "24","July","2002");
    //Thread.sleep(2000);

    AC = new AccountCreatedPage(driver);
    String ActualHeader3 = AC.getAccountCreatedTxt();
    Assert.assertEquals(ActualHeader3, "ACCOUNT CREATED!","Error");
    AC.clickContinueBtn();
    //Thread.sleep(1000);

    String ActualHeader4 = h.getLoggedInAs();
    Assert.assertEquals("Logged in as "+ActualHeader4, "Logged in as Omar","Error");
    //Thread.sleep(1000);

//    h.deleteAccount();
//
//
//    AD = new AccountDeletedPage(driver);
//    String ActualHeader5 = AD.getAccountDeleteTxt();
//    Assert.assertEquals(ActualHeader5, "ACCOUNT DELETED!","Error");
//    AD.contiue();


  }







}

