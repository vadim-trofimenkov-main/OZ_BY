package by.oz.steps;

import by.oz.configurations.TestListener;
import by.oz.pages.HomePage;
import by.oz.utils.PropertyReader;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Selenide.open;

@Log4j2
@Listeners({TestListener.class})
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
        Configuration.baseUrl = propertyReader.getProperty("OZ_BASE_URL", "oz_base_url");
        homePage = new HomePage();
        Configuration.browser = "chrome";
        Configuration.clickViaJs = true;
        Configuration.headless = true;
        Configuration.browserSize = "1920x1080";
        Configuration.pollingInterval = 500;
        Configuration.timeout = 10000;
        Configuration.screenshots = true;
        Configuration.reportsFolder = "target/allure-results";
        open("/");
    }
}
