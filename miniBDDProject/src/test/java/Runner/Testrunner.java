package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( features= "src/main/resources/feature",
glue= {"StepDefinitions"}, dryRun= true,
plugin= {"pretty", "html:target/cucumber.html" ,"json:target/cucumberreport.json"},
monochrome=true)

public class Testrunner extends AbstractTestNGCucumberTests{
    
	
}
