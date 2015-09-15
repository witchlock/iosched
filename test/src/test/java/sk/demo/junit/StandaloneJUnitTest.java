package sk.demo.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import sk.demo.Configuration;
import sk.demo.screens.SessionList;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

public class StandaloneJUnitTest {
    private AppiumDriver<AndroidElement> driver;

    @Before
    public void setUp() throws Exception {
        File app = Configuration.getApk();
        DesiredCapabilities capabilities = Configuration.getDefaultDesiredCapabilities(app);
        driver = Configuration.getAndroidDriver(capabilities);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void shouldListAllSessionsAvailable() {
        SessionList sessionList = new SessionList();
        PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS),
                sessionList);
        assertThat(sessionList.getSessionAmount(), greaterThan(0));
    }

}