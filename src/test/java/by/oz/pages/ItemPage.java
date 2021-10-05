package by.oz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ItemPage {
    private By header = By.xpath("//h1");
    private By addToFavouritesButton = By.xpath("//*[@id='top-page']/div[3]/div/div[1]/div/div[1]/div/div[2]/div");
    private By favouritesLink = By.xpath("//a [@class='top-panel__userbar__favs top-panel__userbar__dlink top-panel__userbar__dlink--slink']");
    private By addToBasketButton = By.className("b-product-control__btn-container");
    private By basketLink = By.className("top-panel__userbar__cart__item");
    private By leaveCommentButton = By.className("b-comment-new__state-btn");
    private By leaveCommentTextArea = By.xpath("//*[@id='rvc-title-h2']/div[2]/div[3]/div[4]/div[1]/div/div[3]/form/div[2]/div/label");
    private By leaveCommentConfirmButton = By.xpath("//*[@id='rvc-title-h2']/div[2]/div[3]/div[4]/div[1]/div/div[3]/form/div[2]/footer/ul/li/button");
    private List<WebElement> reviews;  ////div[@itemprop="com.company.project.tests.review"]

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
//    public BasketPage clickBasketLink() {
//        driver.findElement(basketLink).click();
//        return new BasketPage(driver);
//    }
//
//    public void clickAddToBasketButton(){
//        driver.findElement(addToBasketButton).click();
//    }
//
//    public void clickLeaveCommentButton(){
//        driver.findElement(leaveCommentButton).click();
//    }
//    public void clickLeaveCommentConfirmButton(){
//        driver.findElement(leaveCommentConfirmButton).click();
//    }
//
//    public void leaveCommentInTextArea(String text){
//        driver.findElement(leaveCommentTextArea).sendKeys(text);
//    }
//
//    public List<WebElement> getReviews() {
//        reviews = driver.findElements(By.xpath("//div[@itemprop='com.company.project.tests.review']"));
//        return reviews;
//    }

//    public void leaveComment(String text){
//        clickLeaveCommentButton();
//        leaveCommentInTextArea(text);
//        clickLeaveCommentConfirmButton();
//    }
}
