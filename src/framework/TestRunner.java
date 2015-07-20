package framework;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

//This annotation defines the which calls to use when running the test
@RunWith(Cucumber.class)
//Here we can specify all the options needed to run the tests
//feature - here we can set the path of the Features folder. Can be any number of folders
//glue - Set the path of the step definition files. Can be any number of files
@CucumberOptions(
		features = {"Features"}
		,glue={"stepDefinition"}
		)
 
public class TestRunner {
 
}

