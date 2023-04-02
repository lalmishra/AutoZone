package baseClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseUtilClass
{
    public static WebDriver driver;
    public static Properties config = new Properties();
    public static FileInputStream fis;


    public static void openSeleniumBrowser() throws IOException {
        String chromeDriverPath= System.getProperty("user.dir")+"/drivers/chromedriver.exe";
        String fireFoxDriverPath= System.getProperty("user.dir")+"/drivers/geckodriver.exe";

        try {
            fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        config.load(fis);

        if(config.getProperty("Browser").equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver",chromeDriverPath);
            driver=new ChromeDriver();
        }
        else if(config.getProperty("Browser").equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver",fireFoxDriverPath);

            driver= new FirefoxDriver();
        }

        driver.get(config.getProperty("SiteURL"));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60L, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30L,TimeUnit.SECONDS);

    }

    public static void waitForElementVisible(WebElement elementLocator, int timeout)
    {

        new WebDriverWait(driver, Duration.ofSeconds(timeout)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(elementLocator));
        elementLocator.click();
    }

    public static void implicitWait()
    {
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

    }

    public static void selectDropDown(WebElement locator,String state)
    {
        Select select = new Select(locator);
        select.selectByVisibleText(state);
    }

    @BeforeClass
    public void setupApplication()
    {

        Reporter.log("=====Browser Session Started=====", true);



        Reporter.log("=====Application Started=====", true);
    }


    @AfterClass
    public void closeApplication()
    {

        Reporter.log("=====Browser Session End=====", true);

    }

}
