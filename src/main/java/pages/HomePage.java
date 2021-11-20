package pages;

import org.openqa.selenium.WebDriver;
import utils.Constant;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void getHomePage() {
        getUrl();
        waitUntilUrlContains(Constant.url);
        waitForLoad();
    }
}
