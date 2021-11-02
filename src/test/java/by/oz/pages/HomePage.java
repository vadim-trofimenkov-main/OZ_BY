package by.oz.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class HomePage extends BasePage {
    private String loginButton = ".top-panel__userbar__auth__lbl";
    private String loginPopupElement = "#loginFormLoginEmailLink";
    private String loggedUserElement = ".top-panel__userbar__user--men";
    private String homePageTitle = "a[title='Интернет-магазин OZ.by']";

    @Step("Check Home page is opened")
    @Override
    public boolean isPageOpened() {
        return isExist(homePageTitle);
    }

    @Step("Open Home page")
    public HomePage openPage() {
        open("/home");
        homePage = new HomePage();
        if (isPageOpened()) {
            return this;
        } else throw new RuntimeException("Homepage is not opened");
    }

    @Step("Click login button")
    public LoginPage clickLoginButton() {
        $(loginButton).click();
        $(loginPopupElement).shouldBe(visible);
        loginPage = new LoginPage();
        return loginPage;
    }

    @Step("Check whether user is logged")
    public boolean userShouldBeLogged() {
        return $(loggedUserElement).shouldBe(visible).exists();
    }

    @Step("Check whether user is logged")
    public boolean isUserLogged() {
        return $(loggedUserElement).exists();
    }
}

