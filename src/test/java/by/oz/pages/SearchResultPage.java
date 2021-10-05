package by.oz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPage {
    private List searchResults;

    public ItemPage clickElement(WebElement element) {
        element.click();
        return new ItemPage();
    }

    public List<WebElement> getSearchResults() {
        searchResults = $$(By.xpath("//*[@id='goods-table']//li"));
        return searchResults;
    }
}
