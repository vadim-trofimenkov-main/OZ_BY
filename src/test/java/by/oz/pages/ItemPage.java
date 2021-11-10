package by.oz.pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Log4j2
public class ItemPage extends BasePage {
    private String addToBasketButton = ".addtocart-btn";
    private String addToFavouritesButton = ".b-product-action__label_fav-action";
    private String leaveCommentButton = ".b-comment-new__state-btn";
    private String leaveCommentTextArea = ".b-comment-new__text-container [name='message']";
    private By leaveCommentConfirmButton = By.xpath("//span[contains(text(), 'Задать вопрос')]");
    private ElementsCollection comments;

    @Step("Click add to favourites button")
    public ItemPage clickAddToFavouritesButton() {
        $(addToFavouritesButton).click();
        return this;
    }

    @Step("Click add to basket button")
    public ItemPage clickAddToBasketButton() {
        $(addToBasketButton).shouldHave(text("Положить в корзину")).click();
        $(".second-button").shouldHave(text("Уже в корзине"));
        return this;
    }

    public ItemPage clickLeaveCommentButton() {
        $(leaveCommentButton).click();
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

    @Step("{comment} comment should be displayed")
    public void commentShouldBeDisplayed(String comment) {
        log.info("Check that '{}' comment should be displayed", comment);
        comments = getComments();
        comments.findBy(text(comment)).shouldHave(text(comment));
    }

    @Step("Leave comment {text}")
    public void leaveComment(String text) {
        log.info("Leave '{}' comment", text);
        clickLeaveCommentButton()
                .leaveCommentInTextArea(text)
                .clickLeaveCommentConfirmButton();
    }

    @Override
    public boolean isPageOpened() {
        return isExist(addToBasketButton);
    }
}
