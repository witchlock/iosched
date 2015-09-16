package com.google.samples.apps.iosched.po;

import android.support.test.uiautomator.UiCollection;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiSelector;

/**
 * Created by xke on 9/16/15.
 */
public class SessionListScreen extends MyPageObject {
    UiCollection sessions = new UiCollection(new UiSelector().resourceId("session_target"));

    public SessionListScreen(UiDevice uiDevice) {
        super(uiDevice);
    }

    public UiCollection getSessions() {
        getDevice().waitForIdle(ACTION_TIMEOUT);
        return sessions;
    }

    public UiObject getTopSession() {
        return new UiObject(new UiSelector().text("Keynote").className("android.widget.TextView"));
    }
}
