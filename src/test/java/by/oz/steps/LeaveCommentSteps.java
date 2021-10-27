package by.oz.steps;

import by.oz.pages.ItemPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LeaveCommentSteps extends BaseStep {
    String itemName;
    String comment;
    ItemPage itemPage;

    @Before
    public void init() {
        setUp();
        itemPage = new ItemPage();
    }

    @Given("Login as registered user. {string} is found.")
    public void userIsLoggedItemFound(String name) {
        itemName = name;
        login();
        homePage.searchThroughSearchBox(name);
    }

    @When("User add {string} comment to the item.")
    public void addItemToBasket(String text) {
        comment = text;
        itemPage.leaveComment(comment);
    }

    @Then("User can see the comment in Comments section.")
    public void isItemInBasket() {
        itemPage.commentShouldBeDisplayed(comment);
    }
}
