package by.oz.steps;

import by.oz.pages.BasketPage;
import by.oz.pages.ItemPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BasketSteps extends BaseStep {
    BasketPage basketPage;
    ItemPage itemPage;

    @Before
    public void init() {
        setUp();
        itemPage = new ItemPage();
        basketPage = new BasketPage();
    }

    @Given("User is logged in. Home Page is opened")
    public void loginToOzBy() {
        login();
    }

    @And("{string} is found")
    public void itemIsFound(String text) {
        homePage.searchThroughSearchBox(text);
    }

    @When("Add {string} to basket.")
    public void addItemToBasket(String itemText) {
        itemPage.clickAddToBasketButton();
    }

    @Then("{string} should be in the basket.")
    public void isItemInBasket(String itemText) {
        itemPage
                .clickBasketLink()
                .itemShouldBeInTheBasket(itemText);
    }

    @Given("{string} is in the basket.")
    public void itemIsInTheBasket(String text) {
        itemPage
                .clickBasketLink()
                .itemShouldBeInTheBasket(text);
    }

    @When("Remove {string} from basket.")
    public void removeItemFromBasket(String itemText) {
        basketPage.removeItemFromBasket(itemText);
    }

    @Then("{string} should no longer be in the basket.")
    public void itemIsNotInTheBasket(String itemText) {
        itemPage
                .clickBasketLink()
                .itemShouldBeRemovedFromBasket(itemText);
    }
}

