package pages;

import factory.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import utils.Constant;


import java.time.Duration;
import java.util.List;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait jsWait;
    private JavascriptExecutor jsExec;
    private final int timeOut = 60;


    public BasePage(WebDriver driver) {
        this.driver = DriverFactory.getDriver();
        jsWait = new WebDriverWait(this.driver, 10);
        jsExec = (JavascriptExecutor) this.driver;
    }

    public void getUrl()  {
        driver.get(Constant.url);
    }

    public WebElement getWebElement(By locator) {
        WebElement element = null;
        return element = driver.findElement(locator);

    }

    public List<WebElement> getWebElements(By locator) {
        List<WebElement> webElementList = null;
        return webElementList = driver.findElements(locator);
    }

    public void selectElementBySelectIndex(WebDriver driver,By locator, int index) {
        Select select = new Select(getWebElement(locator));
        select.selectByIndex(index);
    }

    public void  selectElementBySelectValue(By locator, String value) {
        Select select = new Select(getWebElement(locator));
        select.selectByValue(value);
    }

    public boolean isElementPresent(By locator) {
        try {
            jsWait = new WebDriverWait(driver, 20);
            jsWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            jsWait = new WebDriverWait(driver, timeOut);
            return true;
        } catch (Throwable e) {
            jsWait = new WebDriverWait(driver, timeOut);
            return false;
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            jsWait = new WebDriverWait(driver, 20);
            jsWait.until(ExpectedConditions.visibilityOf(element));
            jsWait = new WebDriverWait(driver, timeOut);
            return true;
        } catch (Throwable e) {
            jsWait = new WebDriverWait(driver, timeOut);
            return false;
        }
    }

    public void forceClick(By locator) {
        WebElement element = getWebElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("var evt = document.createEvent('MouseEvents');"
                + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
                + "arguments[0].dispatchEvent(evt);", element);
    }

    public void forceClick(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("var evt = document.createEvent('MouseEvents');"
                + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
                + "arguments[0].dispatchEvent(evt);", element);
    }

    public void actionSendkey(String value) {

        Actions actions = new Actions(driver);
        actions.sendKeys(value).release().build().perform();
    }

    public void sendKey(By locator, String value) {
        driver.findElement(locator).sendKeys(value);
    }

    public void scrollElementCenterOfScreen (By locator) {
        WebElement element = getWebElement(locator);
        String scrollElementCenterOfScreen = "arguments[0].scrollIntoView({block: 'center',});";
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(scrollElementCenterOfScreen, element);
    }

    public void actionClick(By locator) {
        WebElement element = getWebElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public void actionClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public String getText(By locator) {
        WebElement element = getWebElement(locator);
        return element.getText();
    }

    public String getAttribute(By locator, String attributeName) {
        WebElement element = getWebElement(locator);
        return element.getAttribute(attributeName);
    }


    public String getAttribute(WebElement element, String attributeName) {

        return element.getAttribute(attributeName);
    }

    public void clearText(By locator) {
        WebElement element = getWebElement(locator);
        element.clear();
    }

    public void findAndScrollElement(By locator, int scrollAmount) {
        WebElement element = getWebElement(locator);
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/" + scrollAmount + "));";
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(scrollElementIntoMiddle, element);
    }

    public void findAndScrollElement(WebElement element, int scrollAmount) {

        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/" + scrollAmount + "));";
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(scrollElementIntoMiddle, element);
    }

    public void waitUntilClickable(By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofMillis(10)).ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void waitUntilClickable(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofMillis(10)).ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public synchronized boolean waitUntilUrlContains(String expectedValue) {

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(150))
                .pollingEvery(Duration.ofMillis(1000)).ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
        boolean urlExists = wait.until(ExpectedConditions.urlContains(expectedValue));
        if (urlExists) {


            System.out.println("Waited until for URL and contains expected value: " + expectedValue);

        }

        return true;
    }

    public synchronized boolean waitUntilUrlNotContains(String expectedValue)  {

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(150))
                .pollingEvery(Duration.ofMillis(1000)).ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
        boolean urlExists = wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(expectedValue)));
        if (urlExists) {
            System.out.println("Waited until for URL and  not contains expected value: " + expectedValue);
        }

        return true;
    }

    public void waitUntilVisible(By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(80))
                .pollingEvery(Duration.ofMillis(10)).ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitUntilVisible(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(80))
                .pollingEvery(Duration.ofMillis(10)).ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilInvisible(By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(150))
                .pollingEvery(Duration.ofMillis(10)).ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForLoad() {

        try {
            ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                }
            };
            WebDriverWait wait = new WebDriverWait(driver, 240);
            wait.until(pageLoadCondition);
        }catch(Exception e) {
            new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                    ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        }

    }


}
