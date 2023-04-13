// CucumberTestRunner.java
package web.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/web/featurefiles",
        glue = "web.stepdefs",
        plugin = {"pretty", "json:target/cucumber-reports/report.json", "html:target/cucumber-reports/report.html"}
)
public class CucumberTestRunnerWeb extends AbstractTestNGCucumberTests {
}
