package by.oz.tests;

import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber.html",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"},
        monochrome = true,
        features = {"@target/rerun.txt"},
        glue = {"parallel"}
)

public class FailedRunTest extends BaseTest {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
