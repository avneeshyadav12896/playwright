package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

    features = "src/test/resources/features/enquiry.feature",

    glue = {
        "stepdefinitions",
        "bddhooks"
    },

    plugin = {
        "pretty",
        "html:target/cucumber-report.html",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    },

    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}