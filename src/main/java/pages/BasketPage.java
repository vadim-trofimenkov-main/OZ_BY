package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasketPage {
    private WebDriver driver;
    private List<WebElement> basketResults;
    private WebElement element;
    private By checkbox= By.xpath("//input[@class='i-checkbox__real']");
    private By deleteButton= By.xpath("//button[@class='i-button i-button_danger i-button_small remove']");
    private By deleteButtonConfirm= By.xpath("//button[@class='i-button i-button_danger i-button_small remove-yes']");

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getBasketResults() {
        basketResults = driver.findElements(By.xpath("//tr [@class='goods-table__row ']"));
        return basketResults;
    }

    public void removeItemFromBasket(String text){
        basketResults = getBasketResults();
        for (WebElement item : basketResults) {
            if (item.getText().contains(text)) {
                element = item;
                break;
            }
        }
        element.findElement(checkbox).click();
        driver.findElement(deleteButton).click();
        driver.findElement(deleteButtonConfirm).click();
    }
}
