package com.google.samples.apps.iosched;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.Until;
import android.test.InstrumentationTestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.samples.apps.iosched.po.MenuRight;
import com.google.samples.apps.iosched.po.SessionDetails;
import com.google.samples.apps.iosched.po.SessionListScreen;
import com.google.samples.apps.iosched.po.WelcomeScreen;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;

/**
 * Created by xke on 9/15/15.
 */

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class SessionListUiTest {
    private static final long LAUNCH_TIMEOUT = 5000;
    private static final String GOOGLE_IO_APP_PACKAGE = "com.google.samples.apps.iosched";
    private UiDevice mDevice;

    public SessionListUiTest() {
    }


    @Before
    public void setUp() {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.pressHome();

        final String launcherPackage = getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), LAUNCH_TIMEOUT);

        // Launch app
        Context context = InstrumentationRegistry.getContext();
        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(GOOGLE_IO_APP_PACKAGE);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        // Wait for the app to appear
        mDevice.wait(Until.hasObject(By.pkg(GOOGLE_IO_APP_PACKAGE).depth(0)), LAUNCH_TIMEOUT);
    }

    @Test
    public void viewTopSessionDetails() throws UiObjectNotFoundException {

        acceptWelcome();

        SessionListScreen sessionListScreen = new SessionListScreen(mDevice);
        UiObject topSession = sessionListScreen.getTopSession();
        topSession.clickAndWaitForNewWindow();

        SessionDetails sessionDetails = new SessionDetails(mDevice);
        assertThat(sessionDetails.getSessionTitle().getText(), is("Keynote"));

        mDevice.pressBack();
        assertThat(topSession.isEnabled(), is(true));

    }

    @Test
    public void viewSessionListAndSortByThemeAndTopics() throws UiObjectNotFoundException {
        acceptWelcome();

        SessionListScreen sessionListScreen = new SessionListScreen(mDevice);
//        sessionListScreen.scrollUpAndDown();
//        sessionListScreen.sortSessionByTheme("Design");
//        sessionListScreen.getTopSession().clickAndWaitForNewWindow();
//
//        SessionDetails sessionDetails = new SessionDetails(mDevice);
//        assertThat(sessionDetails.hasTheme("Design"), is(true));
//
//        mDevice.pressBack();
//        sessionListScreen.sortSessionByTopics("Android");
//        sessionListScreen.getTopSession().clickAndWaitForNewWindow();
//
//        assertThat(sessionDetails.hasTopics("Android"), is(true));
    }

    private void acceptWelcome() throws UiObjectNotFoundException {
        WelcomeScreen welcomeScreen = new WelcomeScreen(mDevice);
        if(welcomeScreen.isDisplayed()){
            welcomeScreen.accept();
            MenuRight menuRight = new MenuRight(mDevice);
            menuRight.explore();
        }
    }

    private String getLauncherPackageName() {
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);

        PackageManager pm = InstrumentationRegistry.getContext().getPackageManager();
        ResolveInfo resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return resolveInfo.activityInfo.packageName;
    }

}
