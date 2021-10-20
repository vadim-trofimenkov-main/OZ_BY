package by.oz.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseStep {
    private String username, password;

    @Before
    public void init() {
        setUp();
    }

    @Given("Credentials for logging are {string} and {string}.")
    public void saveValidCredentials(String keywordUsername, String keywordPassword) {
        username = keywordUsername;
        password = keywordPassword;
    }

    @When("User does login.")
    public void login() {
        homePage
                .openPage()
                .clickLoginButton()
                .logIn(username, password);
    }

    @Then("User is logged. Home page is opened.")
    public void isUserLogged() {
        homePage.isUserLogged();
    }
}
