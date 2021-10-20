package by.oz.steps;

import by.oz.pages.SearchResultPage;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps extends BaseStep {
    private SearchResultPage searchResultPage;
    private SelenideElement searchItem;

    @Before
    public void init() {
        setUp();
        searchResultPage = new SearchResultPage();
    }

    @Given("User is logged and is on the Home page.")
    public void userLogged() {
        login();
    }

    @When("User does search for {string}.")
    public void searchItemByText(String text) {
        searchItem =
                homePage
                        .searchThroughSearchBox(text)
                        .getSearchedElementByText(text);
    }

    @Then("Item is found. Item has {string} text.")
    public void isItemFound(String text) {
        searchResultPage.isItemFound(searchItem, text);
    }
}
