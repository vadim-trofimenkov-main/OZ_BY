package by.oz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage {
    private WebDriver driver;
    private WebElement element;
    private By loginButton = By.xpath("//span[@class = 'top-panel__userbar__auth__lbl']");
    private By loginPopupElement = By.xpath("//div[@class='i-popup-com.company.project.tests.login']");
    private By loginPopupEmail = By.xpath("//a[@id='loginFormLoginEmailLink']");
    private By loginPopupUsername = By.xpath("//input[@name='cl_email']");
    private By loginPopupPassword = By.xpath("//input[@name='cl_psw']");
    private By loginPopupButton = By.xpath("//button [@class='i-button i-button_full-width i-button_large i-button_primary i-popup__form-button'] ");
    private By loggedUserElement = By.xpath("//a[@class='top-panel__userbar__dlink top-panel__userbar__dlink--drop top-panel__userbar__user top-panel__userbar__user--men']");
    private By searchBox = By.xpath("//input[@id='top-s']");
    private By favouritesLink = By.xpath("//a[@class='top-panel__userbar__favs top-panel__userbar__dlink top-panel__userbar__dlink--slink']");
    private By basketLink = By.className("top-panel__userbar__cart__item");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public BooksPage clickBooksLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
        return new BooksPage(driver);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        element = (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.presenceOfElementLocated(loginPopupElement));
    }

    public void switchToCredentialsTab() {
        driver.findElement(loginPopupEmail).click();
    }

    public void setUsernameField(String username) {
        driver.findElement(loginPopupUsername).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(loginPopupPassword).sendKeys(password);
    }

    public void clickConfirmButton() {
        driver.findElement(loginPopupButton).click();
    }

    public WebElement getLoggedUserElement() {
        return driver.findElement(loggedUserElement);
    }

    public SearchResultPage searchThroughSearchBox(String text) {
        driver.findElement(searchBox).sendKeys(text + Keys.ENTER);
        return new SearchResultPage(driver);
    }

    public FavouritesPage clickFavouritesLink() {
        driver.findElement(favouritesLink).click();
        return new FavouritesPage(driver);
    }

    public BasketPage clickBasketLink() {
        driver.findElement(basketLink).click();
        return new BasketPage(driver);
    }
}

