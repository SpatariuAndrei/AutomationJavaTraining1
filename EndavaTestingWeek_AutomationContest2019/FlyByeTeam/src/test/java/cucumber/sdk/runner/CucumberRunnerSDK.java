package cucumber.sdk.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
//        features = {"src/test/java/cucumber/sdk/features"},
        features = {"src/test/java/cucumber/sdk/features/FailingTests.feature"},
        glue = {"cucumber/sdk/tests", "cucumber/sdk/hooks"},
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml",
                "html:target/cucumber-reports"},
        monochrome = true)

public class CucumberRunnerSDK {
}

