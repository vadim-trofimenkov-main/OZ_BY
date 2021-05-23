package basket;

import baseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasketPage;
import pages.BooksPage;
import pages.ItemPage;
import pages.SearchResultPage;

import java.util.List;

public class AddItemToBasketTest extends BaseTest {
    private SearchResultPage searchResultPage;
    private List<WebElement> allBooks;
    private List<WebElement> basketItems;
    private WebElement requiredBook;
    private WebElement requiredBookFromBasket;
    private ItemPage itemPage;


    @Test
    public void testAddingItemToBasket() {
        BooksPage booksPage = homePage.clickBooksLink("Книги");
        searchResultPage = booksPage.clickLink("Бестселлеры");
        allBooks = booksPage.getBooksResults();
        String text = "Тонкое искусство пофигизма. Парадоксальный способ жить счастливо";
        for (WebElement book : allBooks) {
            if (book.getText().contains(text)) {
                requiredBook = book;
                itemPage = searchResultPage.clickElement(requiredBook);
                break;
            }
        }
        itemPage.clickAddToBasketButton();
        BasketPage basketPage = itemPage.clickBasketLink();
        basketItems = basketPage.getBasketResults();
        for (WebElement book : basketItems) {
            if (book.getText().contains(text)) {
                requiredBookFromBasket = book;
                break;
            }
        }
        Assert.assertTrue(requiredBookFromBasket.getText().contains(text));
    }
}
