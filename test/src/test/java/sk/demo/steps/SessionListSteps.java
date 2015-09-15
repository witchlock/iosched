package sk.demo.steps;

import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import sk.demo.Configuration;
import sk.demo.screens.SessionList;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

/**
 * Created by xke on 9/14/15.
 */
public class SessionListSteps {

    private AndroidDriver driver;

    @Given("the Google account is linked to Google IO application")
    public void linkGoogleAccount() {
        System.out.format("Precondition: need to automate this step to link Google account");
    }

    @When("the Google IO application is launched")
    public void launchApplication() throws Exception {
        driver = TestHooks.launchApk();

    }

    @Then("I should see all the sessions available")
    public void checkSessionList() {
        SessionList sessionList = new SessionList();
        PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS),
                sessionList);
        assertThat(sessionList.getSessionAmount(), greaterThan(0));
    }
}
