package by.oz.steps;

import by.oz.pages.FavouritesPage;
import by.oz.pages.ItemPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FavouritesSteps extends BaseStep {
    FavouritesPage favouritesPage;
    ItemPage itemPage;

    @Before
    public void init() {
        setUp();
        itemPage = new ItemPage();
        favouritesPage = new FavouritesPage();
    }

    @Given("User is logged in. Home Page is opened.")
    public void loginToOzBy() {
        login();
    }

    @And("{string} is found correctly.")
    public void itemIsFound(String text) {
        homePage.searchThroughSearchBox(text);
    }

    @When("Add {string} to favourites.")
    public void addItemToFavourites(String itemText) {
        itemPage.clickAddToFavouritesButton();
    }

    @Then("{string} should be in the favourites.")
    public void isItemInFavourites(String itemText) {
        itemPage
                .clickFavouritesLink()
                .itemShouldExistInFavorites(itemText);
    }

    @Given("{string} is in the favourites.")
    public void itemIsInTheFavourites(String itemText) {
        itemPage
                .clickFavouritesLink()
                .itemShouldExistInFavorites(itemText);
    }

    @When("Remove {string} from favourites.")
    public void removeItemFromFavourites(String itemText) {
        favouritesPage.removeItemFromFavourites(itemText);
    }

    @Then("{string} should no longer be in the favourites.")
    public void itemIsNotInTheFavourites(String itemText) {
        itemPage
                .clickFavouritesLink()
                .itemShouldBeRemovedFromFavorites(itemText);
    }
}
