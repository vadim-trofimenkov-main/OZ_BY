package by.oz.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage extends BasePage {
    private ElementsCollection searchResults;
    private SelenideElement searchedElement;
    private String searchText;

    @Step("Select item {element.getText()} from Search results")
    public ItemPage clickElement(WebElement element) {
        element.click();
        return new ItemPage();
    }

    @Step("Getting search results")
    public ElementsCollection getSearchResults() {
        isPageOpened();
        searchResults = $$("#goods-table li");
        return searchResults;
    }

    @Step("Getting Item by text: {text}")
    public SelenideElement getSearchedElementByText(String text) {
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

    @Step("Search Item is found")
    public void isItemFound(SelenideElement item, String searchText) {
        item.shouldHave(text(searchText));
    }

    @Step("Check Search Result page is opened")
    @Override
    public boolean isPageOpened() {
        return $("h1.breadcrumbs__list__item").shouldHave(text("Найдено")).exists();
    }
}
