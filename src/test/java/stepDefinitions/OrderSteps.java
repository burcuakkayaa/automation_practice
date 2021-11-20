package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class OrderSteps extends BaseSteps {

    @Then("user is on order page")
    public void userIsOnOrderPage() {
        orderPage.checkUrl();
    }

    @And("user should see name of product is same between category and order page")
    public void userShouldSeeNameOfProductIsSameBetweenCategoryAndOrderPage() {
       orderPage.checkProductName(productName);
    }

    @And("user should see quantity of product is same between category and order page")
    public void userShouldSeeQuantityOfProductIsSameBetweenCategoryAndOrderPage() {
        orderPage.checkProductQuantity(productQuantity);
    }

    @And("user should see price of product is same between category and order page")
    public void userShouldSeePriceOfProductIsSameBetweenCategoryAndOrderPage() {
        orderPage.checkProductPrice(productPrice);
    }

    @When("user clicks proceed to checkout button on order page")
    public void userClicksProceedToCheckoutButtonOnOrderPage() {
        orderPage.clickProceedToCheckoutButton();
    }

    @Then("user is on address menu on order page")
    public void userIsOnAddressMenuOnOrderPage() {
        orderPage.checkAddressMenuUrl();
    }

    @Then("user is on shipping menu on order page")
    public void userIsOnShippingMenuOnOrderPage() {
        orderPage.checkUrl();
        orderPage.checkPageHead("SHIPPING");

    }

    @When("user clicks the terms of the service checkbox")
    public void userClicksTheTermsOfTheServiceCheckbox() {
        orderPage.clickTermsCheckBox();
    }

    @Then("user is on payment menu on order page")
    public void userIsOnPaymentMenuOnOrderPage() {
        orderPage.checkPaymentMenuUrl();
        orderPage.checkPageHead("PLEASE CHOOSE YOUR PAYMENT METHOD");
    }

    @When("user selects {string} as payment method")
    public void userSelectsAsPaymentMethod(String paymentOption) {
        orderPage.selectPaymentOption(paymentOption);
    }

    @When("user clicks confirm button")
    public void userClicksConfirmButton() {
        orderPage.clickConfirmButton();
    }

    @Then("user is on order bank wire summary menu on order page")
    public void userIsOnOrderBankWireSummaryMenuOnOrderPage() {
        orderPage.checkPaymentBankwirePage();
        orderPage.checkPageHead("ORDER SUMMARY");
    }

    @Then("user should see order confirmation menu")
    public void userShouldSeeOrderConfirmationMenu() {
        orderPage.checkOrderConfirmationUrl();
        orderPage.checkPageHead("ORDER CONFIRMATION");
    }

    @And("user should see successful message {string}")
    public void userShouldSeeSuccessfulMessage(String message) {
        orderPage.checkConfirmationMessage(message);
    }

    @When("copies total price of products on order page")
    public void copiesTotalPriceOfProductsOnOrderPage() {
        this.totalProductPrice  = orderPage.getTotalPriceOnOrderPage();
    }
}
