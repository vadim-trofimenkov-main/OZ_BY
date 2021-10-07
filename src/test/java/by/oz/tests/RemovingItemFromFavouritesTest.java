//package by.oz.tests;
//
//import by.oz.pages.FavouritesPage;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.util.List;
//
//public class RemovingItemFromFavouritesTest extends BaseTest {
//    private WebElement searchItem;
//    @Test
//    public void testRemovingItemFromFavourites(){
//        FavouritesPage favouritesPage =  homePage.clickFavouritesLink();
//        String text = "Электронный подарочный сертификат на сумму 50 рублей";
//        List<WebElement> items = favouritesPage.getFavouritesResults();
//        for (WebElement item : items) {
//            if (item.getText().contains(text)) {
//                searchItem = item;
//                break;
//            }
//        }
//        favouritesPage.removeItemFromFavourites(text);
//        items = favouritesPage.getFavouritesResults();
//        Assert.assertFalse(items.contains(searchItem), "Item is not removed from com.company.project.tests.favourites");
//    }
//}
