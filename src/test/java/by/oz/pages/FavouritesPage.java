package by.oz.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FavouritesPage extends BasePage {
    private String itemLocator = "//*[contains(text(), '%s')]//ancestor::li";
    private ElementsCollection favouritesResults;
    private SelenideElement item;

    public ElementsCollection getFavouritesResults() {
        return $$("#goods-table li");
    }

    public SelenideElement getElementFromFavouritesByText(String text) {
        favouritesResults = getFavouritesResults();
        return item = $(By.xpath(String.format(itemLocator, text))).shouldBe(visible);
    }

    public void removeItemFromFavourites(String text) {
        item = getElementFromFavouritesByText(text);
        if (isItemInFavorites(text)) {
            item.shouldBe(visible).click();
            item.hover().find(".i-icon-2_delete").shouldBe(visible).click();
            item.hover().find(".item-type-card__controls-button").shouldBe(visible).shouldHave(text("Да, удалить")).click();
        } else throw new RuntimeException("Item is not in the basket");
    }

    public boolean isItemInFavorites(String text) {
        getElementFromFavouritesByText(text);
        return favouritesResults.contains(item);
    }

    public void itemShouldExistInFavorites(String text) {
        favouritesResults = getFavouritesResults();
        favouritesResults.findBy(text(text)).should(exist);
    }

    public void itemShouldBeRemovedFromFavorites(String text) {
        favouritesResults = getFavouritesResults();
        favouritesResults.findBy(text(text)).shouldNot(exist);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }
}
