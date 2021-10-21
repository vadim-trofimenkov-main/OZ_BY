package by.oz.steps;

import by.oz.pages.HomePage;
import by.oz.utils.PropertyReader;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class BaseStep {
    protected PropertyReader propertyReader = new PropertyReader("src/test/resources/configuration.properties");
    protected HomePage homePage;
    protected String username, password;

    @Step("Login as {username} user")
    public void login() {
        if (!homePage.isUserLogged()) {
            homePage
                    .clickLoginButton()
                    .logIn(username, password)
                    .userShouldBeLogged();
        }
    }

    public void setUp() {
        Configuration.baseUrl = propertyReader.getProperty("OZ_BASE_URL", "oz_base_url");
        username = propertyReader.getProperty("OZ_USERNAME", "oz_username");
        password = propertyReader.getProperty("OZ_PASSWORD", "oz_password");
        homePage = new HomePage();
    }
}
