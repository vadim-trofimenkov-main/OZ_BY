package by.oz.tests;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"classpath:features/login.feature"},
        glue = "by/oz/steps",
        plugin = {"pretty", "html:target/cucumber.html",
                "json:target/cucumber.json"}
)

public class LoginTest extends BaseTest {}
