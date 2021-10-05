//package by.oz.tests;
//
//import by.oz.pages.BasketPage;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.util.List;
//
//public class RemoveItemFromBasketTest extends BaseTest {
//    private List<WebElement> basketItems;
//    private WebElement requiredBookFromBasket;
//
//
//    @Test
//    public void testRemovingItemFromBasket() {
//        BasketPage basketPage = homePage.clickBasketLink();
//        String text = "Тонкое искусство пофигизма. Парадоксальный способ жить счастливо";
//        basketItems = basketPage.getBasketResults();
//        for (WebElement book : basketItems) {
//            if (book.getText().contains(text)) {
//                requiredBookFromBasket = book;
//                break;
//            }
//        }
//        basketPage.removeItemFromBasket(text);
//        basketItems = basketPage.getBasketResults();
//        Assert.assertFalse(basketItems.contains(requiredBookFromBasket), "Item is not removed from com.company.project.tests.favourites");
//    }
//}
