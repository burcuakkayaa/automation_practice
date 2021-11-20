package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class OrderPage  extends  BasePage{

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    private final static By productNameTitle = By.xpath("//td/p[@class = 'product-name']/a");
    private final static By productQuantityTitle = By.id("summary_products_quantity");
    private final static By totalProductPriceTitle = By.id("total_product");
    private final static By totalPriceTitle =  By.id("total_price");
    private final static By proceedToCheckOutButton = By.xpath("//a[@class = 'button btn btn-default standard-checkout button-medium']  |  //button[@name = 'processAddress'] | //button[@name = 'processCarrier']");
    private final static By termsCheckbox = By.id("uniform-cgv");
    private final static By pageHeadTitle = By.xpath("//h1[@class = 'page-heading']");
    private final static By bankwire = By.xpath("//a[@class = 'bankwire']");
    private final static By check = By.xpath("//a[@class = 'cheque']");
    private final static By confirmButton = By.xpath("//p/button[@type = 'submit']");
    private final static By confirmationTitle = By.xpath("//p/strong[@class = 'dark']");

    public void checkUrl() {
        waitUntilUrlNotContains(properties.getProperty("addressMenuPageUrl"));
        waitForLoad();
        waitUntilUrlContains(properties.getProperty("orderPageUrl"));
    }

    public void checkProductName(String productName) {
        waitForLoad();
        waitUntilVisible(productNameTitle);
        Assert.assertEquals(productName, getText(productNameTitle));

    }

    public void checkProductQuantity(int productQuantity) {
        waitForLoad();
        waitUntilVisible(productQuantityTitle);

        String[] text = getText(productQuantityTitle).split("\\s+");

        Assert.assertEquals(productQuantity, Integer.parseInt(text[0]));

    }

    public void checkProductPrice(String productPrice) {
        waitForLoad();
        waitUntilVisible(totalProductPriceTitle);
        Assert.assertEquals(productPrice, getText(totalProductPriceTitle));
    }

    public void clickProceedToCheckoutButton() {
        waitUntilVisible(proceedToCheckOutButton);
        findAndScrollElement(getWebElement(proceedToCheckOutButton),15);

        actionClick(proceedToCheckOutButton);
        waitForLoad();
    }

    public void checkAddressMenuUrl() {
        waitForLoad();
        waitUntilUrlContains(properties.getProperty("addressMenuPageUrl"));
    }

    public void clickTermsCheckBox() {
        waitUntilVisible(termsCheckbox);
        findAndScrollElement(getWebElement(termsCheckbox),15);
        actionClick(termsCheckbox);
        waitForLoad();

    }

    public void checkPageHead(String head) {
        waitForLoad();
        waitUntilVisible(pageHeadTitle);
        Assert.assertEquals(head, getText(pageHeadTitle));
    }

    public void checkPaymentMenuUrl() {
        waitForLoad();
        waitUntilUrlContains(properties.getProperty("paymentMenuPageUrl"));
    }

    public void selectPaymentOption(String paymentOption) {
        waitForLoad();
      if(paymentOption.equalsIgnoreCase("bank wire"))  {
                waitUntilVisible(bankwire);
                waitUntilClickableAndClick(bankwire);
        }else {
          waitUntilVisible(check);
          waitUntilClickableAndClick(check);
      }

      waitForLoad();
    }

    public void clickConfirmButton() {
        waitUntilVisible(confirmButton);
        findAndScrollElement(getWebElement(confirmButton),15);
        actionClick(confirmButton);
        waitForLoad();
    }

    public void checkPaymentBankwirePage() {
        waitForLoad();
        waitUntilUrlContains(properties.getProperty("bankWirePaymentUrl"));
    }

    public void checkOrderConfirmationUrl() {
        waitForLoad();
        waitUntilUrlContains(properties.getProperty("orderConfirmationUrl"));
    }

    public void checkConfirmationMessage(String message) {
        waitForLoad();
        waitUntilVisible(confirmationTitle);
        Assert.assertEquals(message,getText(confirmationTitle));

    }

    public String getTotalPriceOnOrderPage() {
        waitForLoad();
        waitUntilVisible(totalPriceTitle);

        return getText(totalPriceTitle);
    }
}
