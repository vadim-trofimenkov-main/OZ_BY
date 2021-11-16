package by.oz.tests;

import by.oz.configurations.TestListener;
import by.oz.utils.PropertyReader;
import com.codeborne.selenide.Configuration;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.*;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
@Listeners({TestListener.class})
public class BaseTest extends AbstractTestNGCucumberTests {
    protected PropertyReader propertyReader = new PropertyReader("src/test/resources/configuration.properties");

    @BeforeTest(description = "Set Up browser")
    public void setUp() {
        Configuration.baseUrl = propertyReader.getProperty("OZ_BASE_URL", "oz_base_url");
        Configuration.browser = "chrome";
        Configuration.clickViaJs = true;
        Configuration.startMaximized = true;
        Configuration.headless = true;
        Configuration.pollingInterval = 500;
        Configuration.timeout = 10000;
        Configuration.screenshots = true;
        Configuration.reportsFolder = "target/allure-results";
        open("/");
    }

//    @AfterTest(alwaysRun = true, description = "Close browser")
//    public void tearDown() {
//        if (getWebDriver() != null) getWebDriver().quit();
//    }
}

