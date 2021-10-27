package by.oz.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ItemPage extends BasePage {
    private String addToBasketButton = ".addtocart-btn";
    private String addToFavouritesButton = ".b-product-action__label_fav-action";
    private String leaveCommentButton = ".b-comment-new__state-btn";
    private String leaveCommentTextArea = ".b-comment-new__text-container [name='message']";
    private By leaveCommentConfirmButton = By.xpath("//span[contains(text(), 'Задать вопрос')]");
    private ElementsCollection comments;

    public ItemPage clickAddToFavouritesButton() {
        $(addToFavouritesButton).shouldBe(visible).click();
        return this;
    }

    public ItemPage clickAddToBasketButton() {
        $(addToBasketButton).shouldHave(text("Положить в корзину")).click();
        $(".second-button").shouldHave(text("Уже в корзине"));
        return this;
    }

    public ItemPage clickLeaveCommentButton() {
        $(leaveCommentButton).shouldBe(visible).click();
        return this;
    }

    public ItemPage clickLeaveCommentConfirmButton() {
        $(leaveCommentConfirmButton).shouldHave(text("Задать вопрос")).click();
        return this;
    }

    public ItemPage leaveCommentInTextArea(String text) {
        $(leaveCommentTextArea).val(text);
        return this;
    }

    public ElementsCollection getComments() {
        return $$("[itemprop='review']");
    }

    public void commentShouldBeDisplayed(String comment) {
        comments = getComments();
        comments.findBy(text(comment)).shouldHave(text(comment));
    }

    public void leaveComment(String text) {
        clickLeaveCommentButton()
                .leaveCommentInTextArea(text)
                .clickLeaveCommentConfirmButton();
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }
}
