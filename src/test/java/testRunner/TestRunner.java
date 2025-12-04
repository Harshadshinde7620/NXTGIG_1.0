package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class TestRunner {

@CucumberOptions(
    features = "src/test/java/features",         // Path to your .feature files
    glue = "stepDefination",                      // Package with step definitions
    tags = "@Loginvalidcreds123",                       // Run only scenarios tagged with @Logininvalidcreds
    plugin = {
        "pretty",                                    // Console output
        "html:target/cucumber-reports-@Loginvalidcreds123.html",         // HTML report
        "json:target/cucumber.json",                 // JSON report
        "junit:target/cucumber.xml"                  // JUnit report
    },
    monochrome = true,                               // Clean console output
    dryRun = false                                   // Check for missing step definitions
)
public class Testrunner extends AbstractTestNGCucumberTests {
}

}
