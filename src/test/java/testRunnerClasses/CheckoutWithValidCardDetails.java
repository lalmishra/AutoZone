package testRunnerClasses;

import baseClasses.BaseUtilClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObejcts.HomePage;

import java.io.IOException;


public class CheckoutWithValidCardDetails {
    HomePage obj;
    @Test
    public void checkoutWithValidCreditCard() throws IOException {
        BaseUtilClass.openSeleniumBrowser();
        HomePage homeobj = PageFactory.initElements(BaseUtilClass.driver,HomePage.class);
        homeobj.clickOnAddVehilcle();
    }



}
