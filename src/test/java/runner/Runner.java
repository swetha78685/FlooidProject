package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;		
	
@RunWith(Cucumber.class)				
@CucumberOptions(
		features="Features",
		glue={"stepdefinition"},
		tags= {"@flooid"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"})	
public class Runner 				
{		

}