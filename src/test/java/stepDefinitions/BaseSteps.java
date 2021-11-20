package stepDefinitions;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import pages.AccountPage;
import pages.CategoryPage;
import pages.HomePage;
import pages.OrderPage;

public class BaseSteps {

    public static WebDriver driver = DriverFactory.getDriver();
    HomePage homePage = new HomePage(driver);
    AccountPage accountPage = new AccountPage(driver);
    CategoryPage categoryPage = new CategoryPage(driver);
    OrderPage orderPage = new OrderPage(driver);

    protected static String productName;
    protected static String productPrice;
    protected static int productQuantity;
    protected static String  totalProductPrice;

}
