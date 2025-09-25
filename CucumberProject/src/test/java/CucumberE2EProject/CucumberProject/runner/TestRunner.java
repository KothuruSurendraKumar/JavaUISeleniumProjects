package CucumberE2EProject.CucumberProject.runner;

import org.testng.annotations.Listeners;

import CucumberE2EProject.CucumberProject.hooks.ExtentReportListener;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Listeners(ExtentReportListener.class)
@CucumberOptions(features="src/test/resources/features",glue={"CucumberE2EProject.CucumberProject.stepImpl","CucumberE2EProject.CucumberProject.hooks"},
monochrome=true,publish=true,plugin = {"pretty", "html:target/cucumber-reports.html","json:target/cucumber.json"},tags="@Register3")

public class TestRunner extends AbstractTestNGCucumberTests{
	
	

}


//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"