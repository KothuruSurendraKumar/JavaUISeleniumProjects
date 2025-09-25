package test.java.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/features",glue= {"test.java.hooks","test.java.Impl"},
monochrome=true,publish=true,plugin = {"pretty", "html:target/cucumber-reports.html","json:target/cucumber.json"},tags="@Login")

public class TestRunner extends AbstractTestNGCucumberTests{

}
