package by.oz.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ItemPage {
    private String addToBasketButton = ".addtocart-btn";
    private String basketLink = ".top-panel__userbar__cart__item";
//    private By header = By.xpath("//h1");
//    private By addToFavouritesButton = By.xpath("//*[@id='top-page']/div[3]/div/div[1]/div/div[1]/div/div[2]/div");
//    private By favouritesLink = By.xpath("//a [@class='top-panel__userbar__favs top-panel__userbar__dlink top-panel__userbar__dlink--slink']");
//    private By leaveCommentButton = By.className("b-comment-new__state-btn");
//    private By leaveCommentTextArea = By.xpath("//*[@id='rvc-title-h2']/div[2]/div[3]/div[4]/div[1]/div/div[3]/form/div[2]/div/label");
//    private By leaveCommentConfirmButton = By.xpath("//*[@id='rvc-title-h2']/div[2]/div[3]/div[4]/div[1]/div/div[3]/form/div[2]/footer/ul/li/button");
//    private ElementsCollection reviews;

//    public void clickAddToFavouritesButton() {
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        WebElement element = (new WebDriverWait(driver, 10)).
//                until(ExpectedConditions.presenceOfElementLocated(addToFavouritesButton));
//        driver.findElement(addToFavouritesButton).click();
//    }
//
//    public FavouritesPage clickFavouritesLink() {
//        driver.findElement(favouritesLink).click();
//        return new FavouritesPage(driver);
//    }
    public BasketPage clickBasketLink() {
        $(basketLink).click();
        return new BasketPage();
    }

    public void clickAddToBasketButton(){
        $(addToBasketButton).click();
        $(".second-button").shouldHave(text("Уже в корзине"));
    }

//    public void clickLeaveCommentButton(){
//        $(leaveCommentButton).click();
//    }
//    public void clickLeaveCommentConfirmButton(){
//        $(leaveCommentConfirmButton).click();
//    }
//
//    public void leaveCommentInTextArea(String text){
//        $(leaveCommentTextArea).sendKeys(text);
//    }
//
//    public ElementsCollection getReviews() {
//        reviews = $$(By.xpath("//div[@itemprop='com.company.project.tests.review']"));
//        return reviews;
//    }
//
//    public void leaveComment(String text){
//        clickLeaveCommentButton();
//        leaveCommentInTextArea(text);
//        clickLeaveCommentConfirmButton();
//    }
}
