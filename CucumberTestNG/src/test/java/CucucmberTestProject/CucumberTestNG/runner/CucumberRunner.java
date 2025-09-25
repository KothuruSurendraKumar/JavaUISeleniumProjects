package CucucmberTestProject.CucumberTestNG.runner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import CucucmberTestProject.CucumberTestNG.utils.RetryListener;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/resources/features",
			glue="CucucmberTestProject.CucumberTestNG.steps",
			plugin = {"pretty", "html:target/cucumber.html","json:target/cucumber.json"},
		    monochrome = true,
		    tags="@tag123"
		)
@Listeners(CucucmberTestProject.CucumberTestNG.utils.RetryListener.class)
public class CucumberRunner extends AbstractTestNGCucumberTests{
	
	@Override
    @DataProvider(parallel = true) 
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
