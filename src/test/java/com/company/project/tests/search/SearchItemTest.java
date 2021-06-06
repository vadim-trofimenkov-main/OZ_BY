package com.company.project.tests.search;

import com.company.project.tests.baseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.company.core.page_object.pages.SearchResultPage;

import java.util.List;

public class SearchItemTest extends BaseTest {
    private WebElement searchItem;
    @Test
    public void testMainSearch() {
        String text = "Тетрадь полуобщая в клетку \"OZ\" (48 листов)";
        SearchResultPage searchResultPage = homePage.searchThroughSearchBox(text);
        List<WebElement> items = searchResultPage.getSearchResults();
        for (WebElement item : items) {
            if (item.getText().contains(text)) {
                searchItem = item;
                break;
            }
        }
        Assert.assertTrue(searchItem.getText().contains(text));
    }
}
