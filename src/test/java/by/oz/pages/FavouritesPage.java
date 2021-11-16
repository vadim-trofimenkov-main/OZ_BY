package by.oz.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;

@Log4j2
public class FavouritesPage extends BasePage {
    private ElementsCollection favouritesResults;
    private SelenideElement item;

    public ElementsCollection getFavouritesResults() {
        return $$("#goods-table li");
    }

    public SelenideElement getElementFromFavouritesByText(String text) {
        return  getFavouritesResults().findBy(text(text));
    }

    @Step("Remove '{text}' item from the Favourites")
    public void removeItemFromFavourites(String text) {
        log.info("Removing '{}' item from the Favourites", text);
        item = getElementFromFavouritesByText(text);
        if (isItemInFavorites(text)) {
            item.click();
            item.hover().find(".i-icon-2_delete").click();
            item.hover().find(".item-type-card__controls-button").shouldHave(text("Да, удалить")).click();
        } else throw new RuntimeException("Item is not in the basket");
    }

    public boolean isItemInFavorites(String text) {
        log.info("Check whether '{}' item is in the Favourites", text);
        favouritesResults = getFavouritesResults();
        getElementFromFavouritesByText(text);
        return favouritesResults.contains(item);
    }

    @Step("'{text}' item should be in the Favourites")
    public void itemShouldExistInFavorites(String text) {
        log.info("Check that '{}' item should be in the Favourites", text);
        item = getElementFromFavouritesByText(text).should(exist);
    }

    @Step("'{text}' item should not be in the Favourites")
    public void itemShouldBeRemovedFromFavorites(String text) {
        log.info("Check that '{}' item should not be in the Favourites", text);
        item = getElementFromFavouritesByText(text).should(exist);
    }

    @Override
    public boolean isPageOpened() {
        return isExist("#user-tab-wishlist");
    }
}
