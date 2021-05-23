package review;

import baseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ItemPage;
import pages.SearchResultPage;

import java.util.List;

public class LeaveCommentTest extends BaseTest {
    private WebElement searchItem;
    private ItemPage itemPage;
    private String comment = "Замечательный товар!";
    private List<WebElement> reviews;
    private WebElement reviewItem;

    @Test
    public void testLeavingAComment() throws InterruptedException {
        String itemText = "Ручка шариковая синяя \"K15\" (1,0 мм)";
        String searchText = "Ручка шариковая синяя";
        SearchResultPage searchResultPage = homePage.searchThroughSearchBox(searchText);
        List<WebElement> items = searchResultPage.getSearchResults();
        for (WebElement item : items) {
            if (item.getText().contains(itemText)) {
                searchItem = item;
                itemPage = searchResultPage.clickElement(searchItem);
                break;
            }
        }
        itemPage.leaveComment(comment);
        Thread.sleep(5000);
        reviews = itemPage.getReviews();
        for (WebElement review : reviews) {
            if (review.getText().contains(comment)) {
                reviewItem = review;
                break;
            }
        }
        Assert.assertTrue(reviewItem.getText().contains(comment), "Comment is not added");
    }
}
