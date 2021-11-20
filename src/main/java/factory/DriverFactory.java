package factory;


import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class DriverFactory {

    private static  final ConfigReader configReader = new ConfigReader();;
    private  static Properties properties;
    public static WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();


    public WebDriver initDriver(String browser) throws IOException {

        System.out.println("browser value is " + browser);
        properties =  configReader.initProp();


        switch (browser) {
            case "chrome":
                CreateChromeDriver chromeDriver = new CreateChromeDriver();
                driver = chromeDriver.startChromeDriver();
                break;
            case "firefox":
                CreateFirefoxDriver firefoxDriver = new CreateFirefoxDriver();
                driver = firefoxDriver.startFirefoxDriver();
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + browser);
        }


        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(properties.getProperty("default_implicitWait")), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(properties.getProperty("default_pageLoadWait")), TimeUnit.MILLISECONDS);




        return driver;
    }

    public static synchronized WebDriver getDriver() {

        return tlDriver.get();
    }
}
