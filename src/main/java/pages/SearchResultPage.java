package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchResultPage {
    private WebDriver driver;
    private List<WebElement> searchResults;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public ItemPage clickElement(WebElement element) {
        element.click();
        return new ItemPage(driver);
    }

    public List<WebElement> getSearchResults() {
        searchResults = driver.findElements(By.xpath("//*[@id='goods-table']//li"));
        return searchResults;
    }
}
