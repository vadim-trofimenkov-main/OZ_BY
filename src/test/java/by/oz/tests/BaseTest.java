package by.oz.tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Log4j2
public class BaseTest extends AbstractTestNGCucumberTests {

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        if (getWebDriver() != null) getWebDriver().quit();
    }
}

