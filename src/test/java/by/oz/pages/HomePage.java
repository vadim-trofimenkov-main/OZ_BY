package by.oz.pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage extends BasePage {
    private String loginButton = ".top-panel__userbar__auth__lbl";
    private String loginPopupElement = "#loginFormLoginEmailLink";
    private String loggedUserElement = ".top-panel__userbar__user--men";
    private String searchBox = "#top-s";
    private By favouritesLink = By.xpath("//a[@class='top-panel__userbar__favs top-panel__userbar__dlink top-panel__userbar__dlink--slink']");
    private String basketLink = ".top-panel__userbar__cart__item";
    private By homePageTitle = By.cssSelector("a[title='Интернет-магазин OZ.by']");

    @Override
    public boolean isPageOpened() {
        return isExist(homePageTitle);
    }

    public HomePage openPage() {
        open("/home");
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
        return loginPage;
    }

    public boolean getLoggedUserElement() {
        return $(loggedUserElement).should(exist).exists();
    }

    public SearchResultPage searchThroughSearchBox(String text) {
        $(searchBox).val(text).pressEnter();
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

