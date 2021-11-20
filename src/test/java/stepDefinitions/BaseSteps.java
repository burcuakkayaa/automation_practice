package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.bs.A;
import org.openqa.selenium.WebDriver;
import pages.AccountPage;
import pages.HomePage;

public class BaseSteps {

    public static WebDriver driver = DriverFactory.getDriver();
    HomePage homePage = new HomePage(driver);
    AccountPage accountPage = new AccountPage(driver);
}
