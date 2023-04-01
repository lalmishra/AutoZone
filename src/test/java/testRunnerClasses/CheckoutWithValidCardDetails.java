package testRunnerClasses;

import baseClasses.BaseUtilClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObejcts.HomePage;

import java.io.IOException;

@Listeners(listeners.Listeners.class)
public class CheckoutWithValidCardDetails {

    @Test
    public void checkoutWithValidCreditCard() throws IOException {
        BaseUtilClass.openSeleniumBrowser();
        HomePage homeobj = PageFactory.initElements(BaseUtilClass.driver,HomePage.class);
        homeobj.clickOnAddVehilcle();
        homeobj.addVehicleDetails("2020","Audi","A3 Premium");
    }



}
