package by.oz.tests;

import by.oz.pages.HomePage;
import by.oz.utils.PropertyReader;
import com.codeborne.selenide.Configuration;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class BaseTest extends AbstractTestNGCucumberTests {
    protected PropertyReader propertyReader = new PropertyReader("src/test/resources/configuration.properties");
    protected HomePage homePage;
    protected String username, password;

    @BeforeTest
    public void setUp() {
        Configuration.baseUrl = propertyReader.getProperty("OZ_BASE_URL", "oz_base_url");
        username = propertyReader.getProperty("OZ_USERNAME", "oz_username");
        password = propertyReader.getProperty("OZ_PASSWORD", "oz_password");
        Configuration.browser = "chrome";
        Configuration.clickViaJs = true;
        Configuration.startMaximized = true;
        Configuration.headless = false;
        Configuration.pollingInterval = 500;
        Configuration.timeout = 10000;
        open("/home");
    }
}

