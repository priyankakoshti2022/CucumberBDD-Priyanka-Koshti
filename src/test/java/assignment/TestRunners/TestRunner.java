package assignment.TestRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features",
		glue="assignment.StepDefs",
		tags = "",
		plugin = {"pretty",
		"html:target/html/htmlreport.html",
        "json:target/json/file.json",
		},
		publish = true,
		monochrome = true,
		dryRun = false
		)

public class TestRunner {

}
