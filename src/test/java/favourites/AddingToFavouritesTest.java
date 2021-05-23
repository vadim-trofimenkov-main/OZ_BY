package favourites;

import baseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FavouritesPage;
import pages.ItemPage;
import pages.SearchResultPage;

import java.util.List;

public class AddingToFavouritesTest extends BaseTest {
    private ItemPage itemPage;
    private WebElement searchItem;

    @Test
    public void testAddingItemToFavourites() {
        SearchResultPage searchResultPage = homePage.searchThroughSearchBox("Подарочный Сертификат");
        List<WebElement> items = searchResultPage.getSearchResults();
        String text = "Электронный подарочный сертификат на сумму 50 рублей";
        for (WebElement item : items) {
            if (item.getText().contains(text)) {
                searchItem = item;
                itemPage = searchResultPage.clickElement(searchItem);
                break;
            }
        }
        itemPage.clickAddToFavouritesButton();
        FavouritesPage favouritesPage = itemPage.clickFavouritesLink();
        items = favouritesPage.getFavouritesResults();
        for (WebElement item : items) {
            if (item.getText().contains(text)) {
                searchItem = item;
                break;
            }
        }
        Assert.assertTrue(searchItem.getText().contains(text), "Item is not added to favourites");
    }
}
