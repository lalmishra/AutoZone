package testRunnerClasses;

import baseClasses.BaseUtilClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObejcts.HomePage;
import pageObejcts.SearchPage;

import java.io.IOException;

@Listeners(listeners.Listeners.class)
public class CheckoutWithValidCardDetails {

    @Test
    public void checkoutWithValidCreditCard() throws IOException {
        BaseUtilClass.openSeleniumBrowser();
        HomePage homeObj = PageFactory.initElements(BaseUtilClass.driver,HomePage.class);
        SearchPage searchObj = PageFactory.initElements(BaseUtilClass.driver,SearchPage.class);
        homeObj.clickOnAddVehilcle();
        homeObj.addVehicleDetails("2020","Audi","A3 Premium");
        homeObj.searchVehicleParts("“Duralast 24DC-DL\n" +
                "Group Size 24 Deep Cycle Marine and RV Battery 550 CCA”");
        searchObj.clickOnFirstSearchResults();
        searchObj.clickOnAddToCartButton();
        searchObj.clickOnViewCartAndCheckoutButton();
        searchObj.clickOnCheckoutButton();
    }



}
