package pageObejcts;

import baseClasses.BaseUtilClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage extends BaseUtilClass {

    public static WebDriver driver;
    public SearchPage(WebDriver driver)
    {
        this.driver=driver;
    }
    @FindBy(how= How.XPATH, using = "(//div[@id=\"search-result-list\"]//div)[1]")
    public WebElement search_Result_FirstItem;

    @FindBy(how= How.XPATH, using = "//*[text()='Add TO CART']")
    public WebElement add_To_Cart_Button;

    @FindBy(how= How.XPATH, using = "//button[@data-testid=\"view-cart-and-checkout-button\"]")
    public WebElement view_cart_and_checkout_button;

    @FindBy(how= How.XPATH, using = "//span[text()='Not Available']")
    public WebElement home_Delivery_Option_NotAvailable;

    @FindBy(how= How.XPATH, using = "//div[text()=\"CHECKOUT\"]")
    public WebElement Checkout_Button;

    @FindBy(how= How.XPATH, using = "//*[text()='Not Available']")
    public WebElement itemNotAvailable;



    public void clickOnFirstSearchResults()
    {

         waitForElementVisible(search_Result_FirstItem,10);


    }
    public void clickOnAddToCartButton()
    {

        waitForElementVisible(add_To_Cart_Button,10);


    }
    public void clickOnViewCartAndCheckoutButton()
    {
        try {
            if (itemNotAvailable.isDisplayed()) {
                System.out.println("Item is not available");
                System.exit(0);
            }
        }
        catch (Exception e)
        {
            waitForElementVisible(view_cart_and_checkout_button, 10);
        }




    }
    public void clickOnCheckoutButton()
    {


        Checkout_Button.click();

    }

}
