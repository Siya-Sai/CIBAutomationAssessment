// CucumberTestRunner.java
package api.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/api/featurefiles",
        tags = "@dogAPI",
        glue = "api.stepdefs",
        plugin = {"pretty", "json:target/cucumber-reports/report.json", "html:target/cucumber-reports/report.html"}
)
public class CucumberTestRunnerApi extends AbstractTestNGCucumberTests {
}
