package by.oz.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    private By loginPopupEmail = By.cssSelector("#loginFormLoginEmailLink");
    private By loginPopupUsername = By.name("cl_email");
    private By loginPopupPassword = By.name("cl_psw");
    private By loginPopupButton = By.cssSelector("div.i-popup__tab-container #loginForm > button[type=submit]");

    @Override
    public boolean isPageOpened() {
        return isExist(loginPopupEmail);
    }

    public LoginPage switchToCredentialsTab() {
        $(loginPopupEmail).click();
        return this;
    }

    public LoginPage setUsernameField(String username) {
        $(loginPopupUsername).val(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        $(loginPopupPassword).val(password);
        return this;
    }

    public HomePage clickConfirmButton() {
        $(loginPopupButton).click();
        return new HomePage();
    }

    public HomePage logIn(String username, String password) {
        LoginPage loginPage = new LoginPage();
        return homePage =
                loginPage
                        .switchToCredentialsTab()
                        .setUsernameField(username)
                        .setPassword(password)
                        .clickConfirmButton();
    }
}
