package by.oz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class BasketPage {
    private List basketResults;
    private WebElement element;
    private By checkbox= By.xpath("//input[@class='i-checkbox__real']");
    private By deleteButton= By.xpath("//button[@class='i-button i-button_danger i-button_small remove']");
    private By deleteButtonConfirm= By.xpath("//button[@class='i-button i-button_danger i-button_small remove-yes']");

    public List getBasketResults() {
        basketResults = $$(By.xpath("//tr [@class='goods-table__row ']"));
        return basketResults;
    }

//    public void removeItemFromBasket(String text){
//        basketResults = getBasketResults();
//        for (List item : basketResults) {
//            if (item.getText().contains(text)) {
//                element = item;
//                break;
//            }
//        }
//        element.findElement(checkbox).click();
//        driver.findElement(deleteButton).click();
//        driver.findElement(deleteButtonConfirm).click();
//    }
}
