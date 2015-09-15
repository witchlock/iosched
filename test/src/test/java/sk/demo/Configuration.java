package sk.demo;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;

/**
 * Created by xke on 9/14/15.
 */
public class Configuration {
    private static final String REMOTE_WEBDRIVER_SERVER = "http://127.0.0.1:4723/wd/hub";
    private static final String APK_NAME = "android-debug.apk";
    private static AndroidDriver androidDriver;


    public static AndroidDriver getAndroidDriver(DesiredCapabilities capabilities) throws MalformedURLException {
        if (null == androidDriver){
            androidDriver = new AndroidDriver<>(new URL(REMOTE_WEBDRIVER_SERVER), capabilities);
        }
        return androidDriver;
    }

    public static File getApk() {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "../android");
        return new File(appDir, APK_NAME);
    }

    public static DesiredCapabilities getDefaultDesiredCapabilities(File app) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("platformVersion", "4.4");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.google.samples.apps.iosched");
        capabilities.setCapability("appActivity", ".ui.BrowseSessionsActivity");
        return capabilities;
    }
}
