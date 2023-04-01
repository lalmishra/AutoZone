package baseClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        driver.manage().timeouts().pageLoadTimeout(60L, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30L,TimeUnit.SECONDS);

    }

    public static void waitForElementVisible(String elementLocator)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds (30));
        WebElement ele= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementLocator)));

    }

}
