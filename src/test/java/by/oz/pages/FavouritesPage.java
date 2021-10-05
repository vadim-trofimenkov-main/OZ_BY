package by.oz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class FavouritesPage {
    private List favouritesResults;
    private WebElement element;

    public List getFavouritesResults() {
        favouritesResults = $$(By.xpath("//ul[@id='goods-table']//li"));
        return favouritesResults;
    }

    public void removeItemFromFavourites(String text){
        favouritesResults = $$(By.xpath("//ul[@id='goods-table']//li"));
//        for (Object item : favouritesResults) {
//            if (item.getText().contains(text)) {
//                element = item;
//                break;
//            }
//        }
//        element.click();
//        ItemPage itemPage = new ItemPage();
//        itemPage.clickAddToFavouritesButton();
    }
}
