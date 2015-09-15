package sk.demo.cucumber;

/**
 * Created by xke on 9/14/15.
 */

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/sk/demo/specs",
        format = {"pretty", "html:build/cucumber"},
        tags = "@sessions")
public class SessionsTest {
}