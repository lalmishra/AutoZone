package pageObejcts;

import baseClasses.BaseUtilClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

    public static WebDriver driver;
    public HomePage(WebDriver driver)
    {
        this.driver=driver;
    }
    @FindBy(how= How.XPATH, using = "(//*[@data-testid=\"add-vehicle-header-btn\"])[1]")
    public WebElement add_Vehicle;


    public void clickOnAddVehilcle()
    {
        add_Vehicle.click();

    }
}
