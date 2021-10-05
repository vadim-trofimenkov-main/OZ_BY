package by.oz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage extends BasePage {
    private By loginButton = By.xpath("//span[@class = 'top-panel__userbar__auth__lbl']");
    private By loginPopupElement = By.id("loginFormLoginEmailLink");
    private By loggedUserElement = By.cssSelector(".top-panel__userbar__user--men");
    private By searchBox = By.id("top-s");
    private By favouritesLink = By.xpath("//a[@class='top-panel__userbar__favs top-panel__userbar__dlink top-panel__userbar__dlink--slink']");
    private By basketLink = By.className("top-panel__userbar__cart__item");
    private By homePageTitle = By.cssSelector("a[title='Интернет-магазин OZ.by']");

    @Override
    public boolean isPageOpened() {
        return isExist(homePageTitle);
    }

    public HomePage openPage() {
        open(homePageLink);
        homePage = new HomePage();
        if (isPageOpened()) {
            return this;
        } else throw new RuntimeException("Homepage is not opened");
    }

    public BooksPage clickBooksLink(String linkText) {
        $(By.linkText(linkText)).click();
        return new BooksPage();
    }

    public LoginPage clickLoginButton() {
        $(loginButton).click();
        $(loginPopupElement).shouldBe(visible);
        loginPage = new LoginPage();
        return new LoginPage();
    }

    public boolean getLoggedUserElement() {
        return $(loggedUserElement).should(exist).exists();
    }

    public SearchResultPage searchThroughSearchBox(String text) {
        $(searchBox).val(text + Keys.ENTER);
        return new SearchResultPage();
    }

    public FavouritesPage clickFavouritesLink() {
        $(favouritesLink).click();
        return new FavouritesPage();
    }

    public BasketPage clickBasketLink() {
        $(basketLink).click();
        return new BasketPage();
    }
}

