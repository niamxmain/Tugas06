package saucedemo.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "/opt/Tugas06/src/test/resource/features",
        glue = "saucedemo.cucumber.stepDefinition",
        plugin = {"html:target/HTML_report.html", "json:target/JSON_report.json", "junit:target/XML_report.xml"},
        tags = "@Regression"
)

public class Run {
}
