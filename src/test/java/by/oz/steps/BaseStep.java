package by.oz.steps;

import by.oz.pages.HomePage;
import by.oz.utils.PropertyReader;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class BaseStep {
    protected PropertyReader propertyReader = new PropertyReader("src/test/resources/configuration.properties");
    protected HomePage homePage;
    protected String username, password;

    @Step("Login in to site")
    public void login() {
        if (!homePage.isUserLogged()) {
            homePage
                    .openPage()
                    .clickLoginButton()
                    .logIn(username, password)
                    .userShouldBeLogged();
        }
    }

    public void setUp() {
        username = propertyReader.getProperty("OZ_USERNAME", "oz_username");
        password = propertyReader.getProperty("OZ_PASSWORD", "oz_password");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false).includeSelenideSteps(false));
        homePage = new HomePage();
    }
}
