package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class CreateFirefoxDriver extends DriverFactory {

    FirefoxOptions firefoxOptions = new FirefoxOptions();
    ProfilesIni allProfiles = new ProfilesIni();
    FirefoxProfile myProfile = allProfiles.getProfile("default");


    public WebDriver startFirefoxDriver() {

        System.setProperty("webdriver.firefox.bin",
                "C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Local\\Mozilla Firefox\\firefox.exe");


        firefoxOptions = getFirefoxOptions();
        WebDriverManager.firefoxdriver().setup();
        tlDriver.set(new FirefoxDriver(firefoxOptions));

        return getDriver();
    }

    private FirefoxOptions getFirefoxOptions() {
        firefoxOptions.setProfile(myProfile);
        firefoxOptions.addArguments("--ignore-certificate-errors", "--ignore-ssl-errors");
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        myProfile.setAcceptUntrustedCertificates(true);
        myProfile.setAssumeUntrustedCertificateIssuer(false);


        return firefoxOptions;
    }

}
