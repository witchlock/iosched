package com.google.samples.apps.iosched.po;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

/**
 * Created by xke on 9/16/15.
 */
public class MenuRight extends MyPageObject {
    UiObject exploreOption = getDevice().findObject(new UiSelector()
            .text("Explore").className("android.widget.TextView"));

    public MenuRight(UiDevice mDevice) {
        super(mDevice);
    }
    public void explore() throws UiObjectNotFoundException {
        exploreOption.clickAndWaitForNewWindow(ACTION_TIMEOUT);
    }
}
