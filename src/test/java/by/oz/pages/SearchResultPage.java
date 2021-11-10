package by.oz.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.NoSuchElementException;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class SearchResultPage extends BasePage {
    private ElementsCollection searchResults;
    private SelenideElement searchedElement;
    private String searchText;

    @Step("Select item {element.getText()} from Search results")
    public ItemPage clickElement(SelenideElement element) {
        if (!isPageOpened()) throw new RuntimeException("Search page is not opened");
        log.info("Select item {} from Search results", element.getText());
        element.click();
        return new ItemPage();
    }

    public ElementsCollection getSearchResults() {
        if (!isPageOpened()) throw new RuntimeException("Search page is not opened");
        searchResults = $$("#goods-table li");
        return searchResults;
    }

    @Step("Search for item: {text} in search results")
    public SelenideElement getSearchedElementByText(String text) {
        log.info("Select item by text {} from Search results", text);
        searchText = text;
        searchResults = getSearchResults();
        for (SelenideElement i : searchResults) {
            if (i.getText().contains(text)) {
                i.shouldBe(visible);
                searchedElement = i;
                break;
            } else throw new NoSuchElementException(String.format("Element with text %s is not found", text));
        }
        return searchedElement;
    }

    @Step("Search Item: {searchText} is found")
    public void isItemFound(SelenideElement item, String searchText) {
        item.shouldHave(text(searchText));
    }

    @Override
    public boolean isPageOpened() {
        return $("h1.breadcrumbs__list__item").shouldHave(text("Найдено")).exists();
    }
}
