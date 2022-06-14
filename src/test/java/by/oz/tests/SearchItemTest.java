package by.oz.tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"classpath:features/search.feature"},
        glue = "by/oz/steps",
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"}
)

public class SearchItemTest extends AbstractTestNGCucumberTests {
}
