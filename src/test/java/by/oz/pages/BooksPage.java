package by.oz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BooksPage extends BasePage{
    private List booksResults;
    private WebElement element;

    public SearchResultPage clickLink(String linkText) {
        $(By.linkText(linkText)).click();
        return new SearchResultPage();
    }

    public List getBooksResults() {
        booksResults = $$(By.xpath("//*[@id='goods-table']//li"));
        return booksResults;
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }
}
