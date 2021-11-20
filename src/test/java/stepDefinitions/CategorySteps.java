package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CategorySteps extends  BaseSteps {


    @And("user clicks {string} category")
    public void userClicksCategory(String categoryName) {
        categoryPage.selectProductOptions(categoryName);
    }


    @Then("user is on category page")
    public void userIsOnCategoryPage() {
        categoryPage.checkCategoryUrl();
    }

    @When("user enters {string} to search area")
    public void userEntersToSearchArea(String searchText) {
        categoryPage.entersValueToSearchText(searchText);
    }

    @And("user selects {int}. product on product list")
    public void userSelectsProductOnProductList(int productNumber) {

        categoryPage.selectProductsToProductList(productNumber);
    }

    @Then("user should see product successfully added window")
    public void userShouldSeeProductSuccessfullyAddedWindow() {
        categoryPage.checkProductSuccessPopUp();
    }

    @When("user copies name of product on window")
    public void userCopiesNameOfProductOnWindow() {
        this.productName = categoryPage.getProductNameOnWindow();

    }

    @And("user copies quantity of product on window")
    public void userCopiesQuantityOfProductOnWindow() {
        this.productQuantity = categoryPage.getProductQuantity();
    }

    @And("user copies price of product on window")
    public void userCopiesPriceOfProductOnWindow() {
        this.productPrice = categoryPage.getProductPrice();
    }

    @And("user closes to window")
    public void userClosesToWindow() {
        categoryPage.clickCloseButton();
    }

    @And("user clicks card menu")
    public void userClicksCardMenu() {
        categoryPage.clickCardMenu();
    }

    @And("user clicks check out on card menu")
    public void userClicksCheckOutOnCardMenu() {
        categoryPage.clickCheckOutButton();
    }


}
