package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FavouritesPage {
    private WebDriver driver;
    private List<WebElement> favouritesResults;
    private WebElement element;

    public FavouritesPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getFavouritesResults() {
        favouritesResults = driver.findElements(By.xpath("//ul[@id='goods-table']//li"));
        return favouritesResults;
    }

    public void removeItemFromFavourites(String text){
        favouritesResults = driver.findElements(By.xpath("//ul[@id='goods-table']//li"));
        for (WebElement item : favouritesResults) {
            if (item.getText().contains(text)) {
                element = item;
                break;
            }
        }
        element.click();
        ItemPage itemPage = new ItemPage(driver);
        itemPage.clickAddToFavouritesButton();
    }
}
