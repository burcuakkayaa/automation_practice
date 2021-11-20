package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Constant;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final static By singIn = By.xpath("//a[@class = 'login']");

    public void getHomePage() {
        getUrl();
        waitUntilUrlContains(Constant.url);
        waitForLoad();
    }

    public void clickSignInButton() {
        waitUntilVisible(singIn);
        waitUntilClickable(singIn);
        waitForLoad();
    }


}
