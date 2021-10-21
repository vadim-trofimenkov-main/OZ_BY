package by.oz.steps;

import by.oz.pages.BasketPage;
import by.oz.pages.ItemPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BasketSteps extends BaseStep {
    BasketPage basketPage;
    ItemPage itemPage;
    String itemText;

    @Before
    public void init() {
        setUp();
        itemPage = new ItemPage();
        basketPage = new BasketPage();
    }

    @Given("User is logged. {string} is found.")
    public void userIsLoggedItemFound(String text) {
        itemText = text;
        login();
        homePage.searchThroughSearchBox(text);
    }

    @When("Add found item to basket.")
    public void addItemToBasket() {
        itemPage.clickAddToBasketButton();
    }

    @Then("Item should be in the basket.")
    public void isItemInBasket() {
        itemPage
                .clickBasketLink()
                .isItemInTheBasket(itemText);
    }

    @Given("{string} is in the basket.")
    public void itemIsInTheBasket(String text) {
        itemText = text;
        itemPage
                .clickBasketLink()
                .isItemInTheBasket(text);
    }

    @When("Remove found item from basket.")
    public void removeItemFromBasket() {
        basketPage.removeItemFromBasket(itemText);
    }

    @Then("Item is no longer in the basket.")
    public void itemIsNotInTheBasket() {
        itemPage
                .clickBasketLink()
                .isItemRemovedFromBasket(itemText);
    }
}

