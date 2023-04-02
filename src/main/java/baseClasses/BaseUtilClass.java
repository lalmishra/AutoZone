package baseClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
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
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseUtilClass
{
    public static WebDriver driver;
    public static Properties config = new Properties();
    public static FileInputStream fis;


    public static void openSeleniumBrowser(String browser) throws IOException {
        String chromeDriverPath= System.getProperty("user.dir")+"/drivers/chromedriver.exe";
        String fireFoxDriverPath= System.getProperty("user.dir")+"/drivers/geckodriver.exe";

        try {
            fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        config.load(fis);

        if(browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver",chromeDriverPath);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-web-security");
            options.addArguments("--no-proxy-server");

            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);

            options.setExperimentalOption("prefs", prefs);
            driver=new ChromeDriver(options);
        }
        else if(browser.equalsIgnoreCase("firefox"))
        {
//            System.setProperty("webdriver.gecko.driver",fireFoxDriverPath);
            FirefoxOptions options = new FirefoxOptions();
            options.setBinary(fireFoxDriverPath);

            driver= new FirefoxDriver(options);
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
