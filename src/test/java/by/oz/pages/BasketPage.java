package by.oz.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BasketPage {
    private ElementsCollection basketResults;
    private SelenideElement element;
    private String checkbox = "//a[contains(text(), '%s')]//ancestor::tr//descendant::input[@type ='checkbox']";
    private String itemLocator = "//a[contains(text(), '%s')]//ancestor::tr";
    private String basketResultslocator = "tr[class='goods-table__row ']";
    private String deleteButton = "button.remove";
    private String deleteButtonConfirm = ".remove-yes";

    public ElementsCollection getBasketResults() {
        basketResults = $$((basketResultslocator));
        return basketResults;
    }

    public void isItemInTheBasket(String text) {
        basketResults = getBasketResults();
        basketResults.findBy(text(text)).should(exist);
    }

    public void isItemRemovedFromBasket(String text) {
        basketResults = getBasketResults();
        basketResults.findBy(text(text)).shouldNot(exist);
    }

    public void removeItemFromBasket(String text) {
        basketResults = getBasketResults();
        element = $(By.xpath(String.format(itemLocator,text))).shouldBe(visible);
        if (basketResults.contains(element)) {
            $(By.xpath(String.format(checkbox, text))).shouldNotBe(checked).click();
            $(deleteButton).shouldBe(visible).click();
            $(deleteButtonConfirm).shouldBe(visible).click();
        } else throw new RuntimeException("Item is not in the basket");
    }
}