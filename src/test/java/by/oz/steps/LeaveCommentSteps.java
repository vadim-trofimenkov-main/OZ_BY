package by.oz.steps;

import by.oz.pages.ItemPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LeaveCommentSteps extends BaseStep {
    ItemPage itemPage;

    @Before
    public void init() {
        setUp();
        itemPage = new ItemPage();
    }

    @Given("User is logged in. Home page is opened.")
    public void loginToOzBy() {
        login();
    }

    @And("{string} is found through search.")
    public void itemIsFound(String text) {
        homePage.searchThroughSearchBox(text);
    }

    @When("User add {string} comment to the item.")
    public void userCommentItem(String comment) {
        itemPage.leaveComment(comment);
    }

    @Then("User can see {string} comment in Comments section.")
    public void commentShouldBeDisplayed(String comment) {
        itemPage.commentShouldBeDisplayed(comment);
    }
}
