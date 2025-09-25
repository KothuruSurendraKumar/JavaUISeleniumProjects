package CucucmberTestProject.CucumberTestNG.steps;

import CucucmberTestProject.CucumberTestNG.utils.DataFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	@Before
	public void intilize() {
		DataFactory.intilizeDriver();
	}
	
	@After
	public void close() {
		DataFactory.quitDriver();
	}

}
