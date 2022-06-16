package by.oz.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class LoginPage extends BasePage {

    private String loginPopupEmail = "#loginFormLoginEmailLink";
    private String loginPopupUsername = "cl_email";
    private String loginPopupPassword = "cl_psw";
    private String loginPopupButton = "div.i-popup__tab-container #loginForm > button[type=submit]";

    @Override
    public boolean isPageOpened() {
        return isExist(loginPopupEmail);
    }

    public LoginPage switchToCredentialsTab() {
        $(loginPopupEmail).click();
        return this;
    }

    public LoginPage setUsernameField(String username) {
        log.info("Entering username: {}", username);
        $(By.name(loginPopupUsername)).val(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        log.info("Entering password: {}", password);
        $(By.name(loginPopupPassword)).val(password);
        return this;
    }

    public HomePage clickConfirmButton() {
        $(loginPopupButton).click();
        return new HomePage();
    }

    public HomePage logIn(String username, String password) {
        log.info("Logging as user with username: {} and password: {}", username, password);
        LoginPage loginPage = new LoginPage();
        return homePage =
                loginPage
                        .switchToCredentialsTab()
                        .setUsernameField(username)
                        .setPassword(password)
                        .clickConfirmButton();
    }
}
