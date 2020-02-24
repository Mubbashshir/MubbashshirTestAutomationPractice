package Com.bpdts.testrunner;
/**
 * 
 */

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * @Mubbashshir Mohiuddin
 *  */
@RunWith(Cucumber.class)
@CucumberOptions(features ="C:\\Users\\User\\eclipse-workspace\\BPDTSAutomationTest\\src\\test\\resource\\features",
                 glue = {"Com.bpdts.teststeps"},
plugin={ "json:target/cucumber.json",
"html:target/cucumber-reports"})
public class TestRunner {
}


