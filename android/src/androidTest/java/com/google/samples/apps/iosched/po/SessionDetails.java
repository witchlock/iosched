package com.google.samples.apps.iosched.po;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

/**
 * Created by xke on 9/16/15.
 */
public class SessionDetails extends MyPageObject {

    public SessionDetails(UiDevice mDevice) {
        super(mDevice);
    }

    public UiObject getSessionTitle() throws UiObjectNotFoundException {
        return new UiObject(new UiSelector().className("android.widget.TextView").instance(3));
    }
}
