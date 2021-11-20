package myhooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

import java.io.IOException;
import java.util.Properties;

public class BaseHooks {

    private DriverFactory driverFactory;
    public static WebDriver driver;
    private ConfigReader configReader;
    Properties properties;


    @Before(order = 0)
    public void init(Scenario scenario) throws IOException {
        configReader = new ConfigReader();
        properties = configReader.initProp();
        System.out.println("Scenario name: " + scenario.getName());
    }

    @Before("@chrome")
    public void launchBrowserAsChrome() throws IOException {

        driverFactory = new DriverFactory();
        driver = driverFactory.initDriver("chrome");

    }

    @Before("@firefox")
    public void launchBrowserAsFirefox() throws IOException {

        driverFactory = new DriverFactory();
        driver = driverFactory.initDriver("firefox");

    }

    @After(order = 0)
    public void quit() {

        driverFactory.getDriver().quit();
    }


    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()) {
            //take screenshot
            String screenshotName=  scenario.getName().replaceAll(" ", "_");

            byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);

            scenario.attach(sourcePath, "image/png", screenshotName);

        }
    }
}
