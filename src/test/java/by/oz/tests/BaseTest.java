package by.oz.tests;

import by.oz.pages.HomePage;
import by.oz.utils.PropertyReader;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {
    protected PropertyReader propertyReader = new PropertyReader("src/test/resources/configuration.properties");
    protected HomePage homePage;
    protected String username, password;

    @BeforeClass
    public void setUp() {
        Configuration.baseUrl = propertyReader.getProperty("OZ_BASE_URL", "oz_base_url");
        username = propertyReader.getProperty("OZ_USERNAME","oz_username");
        password = propertyReader.getProperty("OZ_PASSWORD", "oz_password");
        Configuration.browser = "chrome";
        Configuration.clickViaJs = true;
        Configuration.startMaximized = true;
        Configuration.headless = false;
        Configuration.pollingInterval = 500;
        Configuration.timeout = 10000;
        homePage = new HomePage();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (getWebDriver() != null) getWebDriver().quit();
    }
}
