package by.oz.tests;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"classpath:features/comment.feature"},
        glue = "by/oz/steps",
        plugin = {"pretty", "html:target/cucumber.html",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"}
)

public class LeaveCommentTest extends BaseTest {
}
