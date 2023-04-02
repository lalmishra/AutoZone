package pageObejcts;

import baseClasses.BaseUtilClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckoutPage extends BaseUtilClass {

    public static WebDriver driver;
    public CheckoutPage(WebDriver driver)
    {
        this.driver=driver;
    }


    @FindBy(how= How.XPATH, using = "//button[@id=\"continueAsGuestCartTrigger\"]")
    public WebElement continueAsGuest_Button;

    @FindBy(how= How.XPATH, using = "//button[@data-testid=\"delivery-options-continue-btn\"]")
    public WebElement deliveryOptionsContinue_Button;

    @FindBy(how= How.XPATH, using = "//input[@id=\"cardNumber\"]")
    public WebElement CreditCard;

    @FindBy(how= How.XPATH, using = "//input[@id=\"securityCode\"]")
    public WebElement securityCode;

    @FindBy(how= How.XPATH, using = "//input[@id=\"expiry\"]")
    public WebElement expiry;

    @FindBy(how= How.XPATH, using = "//button[@id=\"at_submit_button_address_form\"]")
    public WebElement PaymentContinueButton;

    @FindBy(how= How.XPATH, using = "//button[@id=\"at_submit_button_address_form\"]")
    public WebElement BillingContinueButton;

    @FindBy(how= How.XPATH, using = "//input[@id=\"firstName\"]")
    public WebElement firstName;


    @FindBy(how= How.XPATH, using = "//input[@id=\"lastName\"]")
    public WebElement lastName;

    @FindBy(how= How.XPATH, using = "//input[@id=\"phoneNumber\"]")
    public WebElement phoneNumber;

    @FindBy(how= How.XPATH, using = "//input[@id=\"email\"]")
    public WebElement emailAdd;

    @FindBy(how= How.XPATH, using = "//input[@id=\"address1\"]")
    public WebElement address1;

    @FindBy(how= How.XPATH, using = "//input[@id=\"city\"]")
    public WebElement cityName;

    @FindBy(how= How.XPATH, using = "//select[@data-testid=\"checkout-address-form-state\"]")
    public WebElement stateName;
    @FindBy(how= How.XPATH, using = "//input[@id=\"zipCode\"]")
    public WebElement zipCode;

    @FindBy(how= How.XPATH, using = "//button[@data-testid=\"complete-purchase-btn\"]")
    public WebElement completePurchaseButton;
    @FindBy(how= How.XPATH, using = "//*[@data-testid=\"notificationAlert\"]")
    public WebElement notificationAlert;



    public void clickContinueAsGuestButton()
    {

            waitForElementVisible(continueAsGuest_Button,10);

        waitForElementVisible(deliveryOptionsContinue_Button,10);


    }

    public void enterCardDetails(String creditCard, String expiryDate, String security_Code)
    {

        CreditCard.sendKeys(creditCard);
        expiry.sendKeys(expiryDate);
        securityCode.sendKeys(security_Code);

        waitForElementVisible(PaymentContinueButton,10);


    }

    public void enterBillingAddressDetails(String fn, String ln, String phone,String email,String add1,String city, String state, String zip)
    {

        firstName.sendKeys(fn);
        lastName.sendKeys(ln);
        phoneNumber.sendKeys(phone);
        emailAdd.sendKeys(email);
        address1.sendKeys(add1);
        cityName.sendKeys(city);
        selectDropDown(stateName,state);
        zipCode.sendKeys(zip);


        waitForElementVisible(BillingContinueButton,10);
        waitForElementVisible(completePurchaseButton, 10);
        try {
            if (notificationAlert.isDisplayed()) {
                String notification = notificationAlert.getText();
                System.out.println(notification);
                System.exit(0);
            }
        }
        catch (Exception e)
        {


        }



    }




}
