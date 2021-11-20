package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HomePageSteps extends BaseSteps {

    @Given("user is on main page")
    public void user_is_on_main_page() {
        homePage.getHomePage();

    }

    @When("user clicks sign in option")
    public void user_clicks_sign_in_option() {

    }
}
