package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoryPage extends BasePage {

    public CategoryPage(WebDriver driver) {
        super(driver);
    }
    private final static By dressedCategoryOptions = By.xpath("//ul[@class = 'tree dynamized']/child::li");
    private final static By seacrhArea = By.id("search_query_top");
    private final static By productList = By.xpath("//ul[@class = 'product_list grid row']/child::li/div");
    private final By addToCardButton = By.xpath("//a[@title = 'Add to cart']");
    private final By productNameTitle = By.id("layer_cart_product_title");
    private final By productQuantityTitle = By.id("layer_cart_product_quantity");
    private final By productPriceTitle = By.xpath("//span[@class = 'ajax_block_products_total']");
    private final By productLayerCard = By.id("layer_cart");
    private final By closeProductPopUp = By.xpath("//span[@title = 'Close window']");
    private final By cardArea = By.xpath("//div[@class = 'shopping_cart']/a");
    private final By checkoutButton = By.id("button_order_cart");

    public void selectProductOptions(String categoryOptionsName) {
        waitForLoad();

        for(WebElement element : getWebElements(dressedCategoryOptions))
            waitUntilVisible(element);

        switch (categoryOptionsName) {
            case "Casual Dresses":
                waitUntilClickableAndClick(getWebElements(dressedCategoryOptions).get(0));
                break;
            case "Evening Dresses":
                waitUntilClickableAndClick(getWebElements(dressedCategoryOptions).get(1));
                break;
            case "Summer Dresses":
                waitUntilClickableAndClick(getWebElements(dressedCategoryOptions).get(2));
                break;

        }
        waitForLoad();
    }


    public void checkCategoryUrl() {
        waitForLoad();
        waitUntilUrlContains(properties.getProperty("categoryPageUrl"));
    }

    public void entersValueToSearchText(String searchText) {
        waitUntilVisible(seacrhArea);
        waitUntilClickableAndClick(seacrhArea);
        sendKey(seacrhArea,searchText);
        waitForLoad();
    }

    public void selectProductsToProductList(int productNumber) {
        waitForLoad();

        for(WebElement element : getWebElements(productList))
            waitUntilVisible(element);

        findAndScrollElement(getWebElements(productList).get(productNumber-1),10);
        actionClick(getWebElements(productList).get(productNumber-1));
        forceClick(getWebElements(addToCardButton).get(productNumber-1));
    }

    public void checkProductSuccessPopUp() {
        waitForLoad();
        waitUntilVisible(productLayerCard);
    }

    public String getProductNameOnWindow() {
        waitForLoad();
        waitUntilVisible(productNameTitle);

        return getText(productNameTitle);
    }

    public int getProductQuantity() {
        waitForLoad();
        waitUntilVisible(productQuantityTitle);

        return Integer.parseInt(getText(productQuantityTitle));
    }

    public String getProductPrice() {
        waitForLoad();
        waitUntilVisible(productPriceTitle);

        return getText(productPriceTitle);
    }

    public void clickCloseButton() {
        waitForLoad();
        waitUntilVisible(closeProductPopUp);
        waitUntilClickableAndClick(closeProductPopUp);

    }

    public void clickCardMenu() {
        waitForLoad();
        waitUntilVisible(cardArea);
        findAndScrollElement(cardArea,20);
        clickAndHold(getWebElement(cardArea));


    }

    public void clickCheckOutButton() {
        waitForLoad();
        waitUntilVisible(checkoutButton);
        waitUntilClickableAndClick(checkoutButton);
    }
}
