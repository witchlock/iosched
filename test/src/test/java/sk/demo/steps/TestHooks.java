package sk.demo.steps;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

import io.appium.java_client.android.AndroidDriver;
import sk.demo.Configuration;

/**
 * Created by xke on 9/14/15.
 */
public class TestHooks {

    private static AndroidDriver driver;

    public static AndroidDriver launchApk() throws Exception {
        File app = Configuration.getApk();
        DesiredCapabilities capabilities = Configuration.getDefaultDesiredCapabilities(app);
        driver = Configuration.getAndroidDriver(capabilities);
        return driver;
    }

    public static void closeApp() throws Exception {
        driver.quit();
    }
}
