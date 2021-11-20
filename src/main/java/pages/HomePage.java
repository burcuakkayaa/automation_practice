package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Constant;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final static By singIn = By.xpath("//a[@class = 'login']");
    private final static By accountTitle = By.xpath("//a[@class = 'account']");

    public void getHomePage() {
        getUrl();
        waitUntilUrlContains(Constant.url);
        waitForLoad();
    }

    public void clickSignInButton() {
        waitUntilVisible(singIn);
        waitUntilClickableAndClick(singIn);
        waitForLoad();
    }


    public void clickAccountTitle() {
        waitUntilVisible(accountTitle);
        waitUntilClickableAndClick(accountTitle);
        waitForLoad();
    }
}
