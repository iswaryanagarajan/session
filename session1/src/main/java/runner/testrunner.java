package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;




//@RunWith(Cucumber.class)				
@CucumberOptions(features="Features",glue={"StepDefinition"})

public class testrunner {
	
}
