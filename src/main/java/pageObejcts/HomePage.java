package pageObejcts;

import baseClasses.BaseUtilClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

public class HomePage {

    public static WebDriver driver;
    public HomePage(WebDriver driver)
    {
        this.driver=driver;
    }
    @FindBy(how= How.XPATH, using = "(//*[@data-testid=\"add-vehicle-header-btn\"])[1]")
    public WebElement add_Vehicle;

    @FindBy(how= How.XPATH, using = "//input[@id=\"yearheader\"]")
    public WebElement add_Vehicle_Year;

    @FindBy(how= How.XPATH, using = "//input[@id=\"makeheader\"]")
    public WebElement add_Vehicle_Make;

    @FindBy(how= How.XPATH, using = "//input[@id=\"modelheader\"]")
    public WebElement add_Vehicle_Model;

    @FindBy(how= How.XPATH, using = "//input[@data-testid=\"desktop-search-input\"]")
    public WebElement search_Vehicle_Parts;

    public void clickOnAddVehilcle()
    {
        add_Vehicle.click();

    }

    public void addVehicleDetails(String vehicleYear,String vehicleMake, String vehicleModel)
    {
        Reporter.log("Adding vehicle details");
        add_Vehicle_Year.sendKeys(vehicleYear);
        add_Vehicle_Year.sendKeys(Keys.TAB);
        add_Vehicle_Make.sendKeys(vehicleMake);
        add_Vehicle_Make.sendKeys(Keys.TAB);
        add_Vehicle_Model.sendKeys(vehicleModel);
        add_Vehicle_Model.sendKeys(Keys.TAB);
        Reporter.log("Vehicle details added");

    }

    public void searchVehicleParts(String partsDetail)
    {
        search_Vehicle_Parts.sendKeys(partsDetail);
//        search_Vehicle_Parts.sendKeys(Keys.TAB);

    }
}
