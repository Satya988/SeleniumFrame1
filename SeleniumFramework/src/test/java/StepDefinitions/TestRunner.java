package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/login.feature",glue={"StepDefinitions"},
monochrome=true,plugin={"pretty","json:target/JSONreports/Cuc.json","html:target/CucumberHTMLreport/Cuchtml.html",
		"junit:target/Junitreports/Cuc.xml"})
public class TestRunner {

}
