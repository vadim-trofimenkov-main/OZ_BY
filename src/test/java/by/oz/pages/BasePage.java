package by.oz.pages;

import by.oz.utils.PropertyReader;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.NoSuchElementException;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public abstract class BasePage {
    protected PropertyReader propertyReader = new PropertyReader("src/test/resources/configuration.properties");
    private String basketLink = ".top-panel__userbar__cart__item";
    private String favouritesLink = ".top-panel__userbar__favs";
    private String searchBox = "#top-s";
    protected HomePage homePage;
    protected LoginPage loginPage;

    public abstract boolean isPageOpened();

    public boolean isExist(String locator) {
        try {
            return $(locator).shouldBe(visible).exists();
        } catch (NoSuchElementException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public FavouritesPage clickFavouritesLink() {
        $(favouritesLink).hover().click();
        return new FavouritesPage();
    }

    public BasketPage clickBasketLink() {
        $(basketLink).hover().click();
        return new BasketPage();
    }

    public SearchResultPage searchThroughSearchBox(String text) {
        log.info("Searching by text '{}' in search box", text);
        $(searchBox).val(text).pressEnter();
        return new SearchResultPage();
    }
}
