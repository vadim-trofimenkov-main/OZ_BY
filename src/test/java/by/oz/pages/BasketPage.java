package by.oz.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Log4j2
public class BasketPage extends BasePage {
    private ElementsCollection basketResults;
    private SelenideElement element;
    private String checkbox = "//a[contains(text(), '%s')]//ancestor::tr//descendant::input[@type ='checkbox']";
    private String itemLocator = "//a[contains(text(), '%s')]//ancestor::tr";
    private String basketResultsLocator = "tr[class='goods-table__row ']";
    private String deleteButton = "button.remove";
    private String deleteButtonConfirm = ".remove-yes";
    private String confirmOrderButton = "#checkout-block-submit";

    public ElementsCollection getBasketResults() {
        basketResults = $$((basketResultsLocator));
        return basketResults;
    }

    @Step("Check that '{text}' item is in the Basket")
    public void itemShouldBeInTheBasket(String text) {
        log.info("Check that {} item is in the Basket", text);
        basketResults = getBasketResults();
        basketResults.findBy(text(text)).should(exist);
    }

    @Step("Check that '{text}' item is removed from the Basket")
    public void itemShouldBeRemovedFromBasket(String text) {
        log.info("Check that {} item is removed from the Basket", text);
        basketResults = getBasketResults();
        basketResults.findBy(text(text)).shouldNot(exist);
    }

    @Step("Remove '{text}' item from the Basket")
    public void removeItemFromBasket(String text) {
        log.info("Removing '{}' item from the Basket", text);
        if (!isPageOpened()) throw new RuntimeException("Page is not opened");
        basketResults = getBasketResults();
        element = $(By.xpath(String.format(itemLocator, text))).shouldBe(visible);
        if (basketResults.contains(element)) {
            $(By.xpath(String.format(checkbox, text))).shouldNotBe(checked).click();
            $(deleteButton).click();
            $(deleteButtonConfirm).click();
        } else throw new RuntimeException("Item is not in the basket");
    }

    @Override
    public boolean isPageOpened() {
        return isExist(confirmOrderButton);
    }
}