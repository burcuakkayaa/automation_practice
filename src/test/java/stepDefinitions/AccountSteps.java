package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountSteps extends BaseSteps {

    private String name;
    private String surname;
    private String email;
    private int password;
    private Faker faker = new Faker();
    private String mobilePhone;
    private String aliasAdress;
    private String address;
    private String cityName;
    private String zip;

    @Then("user should see on create account page")
    public void user_should_see_on_create_account_page() {
         accountPage.checkUrl();
    }
    @When("user enters an email to send email textbox")
    public void user_enters_an_email_to_send_email_textbox() {

        this.name = faker.name().firstName().toLowerCase();
        this.surname = faker.name().lastName().toLowerCase();
        email = name + surname + "@gmail.com";

        System.out.println(name);
        System.out.println(surname);
        System.out.println(email);

        accountPage.enterEmail(email);
    }

    @When("user clicks create an account button")
    public void user_clicks_create_an_account_button() {
           accountPage.clickSubmitButton();
    }

    @Then("user should see personal information form")
    public void user_should_see_personal_information_form() {
       accountPage.checkAccountPageFormTitles();
    }

    @When("user selects title {string}")
    public void user_selects_title(String gender) {
       accountPage.selectGender(gender);
    }

    @And("user enters a name")
    public void userEntersAName() {

        accountPage.enterName(name);
    }

    @And("user enters a surname")
    public void userEntersASurname() {
        accountPage.enterSurname(surname);
    }


    @And("user checks email has already entered")
    public void userChecksEmailHasAlreadyEntered() {
        accountPage.checkEmailAlreadyEntered(email);
    }

    @And("user enters a password")
    public void userEntersAPassword() {
       this.password = faker.number().numberBetween(10000,100000);
       accountPage.enterPassword(password);
    }

    @And("user selects dates of birth {string}")
    public void userSelectsDatesOfBirth(String birthday) {

         accountPage.entersBirthday(birthday);

    }

    @And("user checks name has already entered to address form area")
    public void userChecksNameHasAlreadyEnteredToAddressFormArea() {
        accountPage.checkNameAlreadyEntered(name);
    }

    @And("user checks surname has already entered to address form area")
    public void userChecksSurnameHasAlreadyEnteredToAddressFormArea() {
        accountPage.checkSurnameAlreadyEntered(surname);
    }

    @And("user enters an address")
    public void userEntersAnAddress() {
        this.address = faker.address().streetAddress();
        accountPage.enterAddress(address);
    }

    @And("user enters a city")
    public void userEntersACity() {
        this.cityName = faker.address().cityName();
        accountPage.enterCity(cityName);
    }

    @And("user selects {int}. state")
    public void userSelectsState(int stateNumber) {
        accountPage.selectState(stateNumber);
    }

    @And("user enters a zip code")
    public void userEntersAZipCode() {
        this.zip = faker.address().zipCode().substring(0,5).trim();
        accountPage.enterZipCode(zip);
    }

    @And("user selects a country")
    public void userSelectsACountry() {
        accountPage.selectCountry();
    }

    @And("user enters a mobile phone")
    public void userEntersAMobilePhone() {
       this.mobilePhone = faker.phoneNumber().cellPhone();
       accountPage.enterPhoneNumber(mobilePhone);
    }

    @And("user enters an address alias for future reference")
    public void userEntersAnAddressAliasForFutureReference() {
        this.aliasAdress = faker.address().secondaryAddress();
        accountPage.enterAliasAddress(aliasAdress);
    }

    @And("user clicks register button")
    public void userClicksRegisterButton() {
        accountPage.clickAccountFormSubmitButton();
    }

    @Then("user should see account categories on my account page")
    public void userShouldSeeAccountCategoriesOnMyAccountPage() {
        accountPage.checkAccountCategories();
    }

    @And("user should see account has already signed in")
    public void userShouldSeeAccountHasAlreadySignedIn() {
        accountPage.checkAccountHasAlreadySignedIn(name, surname);
    }

    @Given("user select {string} category")
    public void userSelectCategory(String categoryOptionsName) {
        accountPage.selectProductCategory(categoryOptionsName);
    }

    @When("user clicks {string} to category")
    public void userClicksToCategory(String categoryName) {
        accountPage.clickAccountCategory(categoryName);
    }

    @Then("user is on order history menu on account page")
    public void userIsOnOrderHistoryMenuOnAccountPage() {
        accountPage.checkHistoryMenuUrl();
    }

    @And("user checks total price on history menu")
    public void userChecksTotalPriceOnHistoryMenu() {
        accountPage.checkTotalPriceOnHistory(totalProductPrice);
    }
}
