package by.oz.steps;

import by.oz.pages.FavouritesPage;
import by.oz.pages.ItemPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FavouritesSteps extends BaseStep {
    FavouritesPage favouritesPage;
    ItemPage itemPage;
    String itemText;

    @Before
    public void init() {
        setUp();
        itemPage = new ItemPage();
        favouritesPage = new FavouritesPage();
    }

    @Given("Login as user. {string} is found.")
    public void userIsLoggedItemFound(String text) {
        itemText = text;
        login();
        homePage.searchThroughSearchBox(text);
    }

    @When("Add found item to favourites.")
    public void addItemToFavourites() {
        itemPage.clickAddToFavouritesButton();
    }

    @Then("Item should be in the favourites.")
    public void isItemInFavourites() {
        itemPage
                .clickFavouritesLink()
                .itemShouldExistInFavorites(itemText);
    }

    @Given("{string} is in the favourites.")
    public void itemIsInTheFavourites(String text) {
        itemText = text;
        itemPage
                .clickFavouritesLink()
                .itemShouldExistInFavorites(text);
    }

    @When("Remove found item from favourites.")
    public void removeItemFromFavourites() {
        favouritesPage.removeItemFromFavourites(itemText);
    }

    @Then("Item is no longer in the favourites.")
    public void itemIsNotInTheFavourites() {
        itemPage
                .clickFavouritesLink()
                .itemShouldBeRemovedFromFavorites(itemText);
    }
}
