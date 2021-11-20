package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class CreateChromeDriver  extends  DriverFactory {

    ChromeOptions chromeOptions = new ChromeOptions();



    public WebDriver startChromeDriver() {
        WebDriverManager.chromedriver().setup();
        chromeOptions = getOptions();
        tlDriver.set(new ChromeDriver(chromeOptions));


        return  getDriver();
    }

    private ChromeOptions getOptions() {

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        chromeOptions.setExperimentalOption("prefs", prefs);
        chromeOptions.addArguments("-disable-cache"
                ,"--incognito"
                ,"start-maximized"
                , "--no-sandbox"
                ,"--disable-gpu"
                ,"--disable-dev-shm-usage"
                ,"--disable-infobars"
                ,"--enable-automation"
                ,"--window-size=1920,1080"
                ,"--ignore-certificate-errors"
                ,"--ignore-ssl-errors"
                ,"--disable-cache"
                ,"--silent"
                ,"--log-level=3");


        chromeOptions.setExperimentalOption("useAutomationExtension", false);
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        return chromeOptions;
    }
}
