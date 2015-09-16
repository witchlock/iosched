package com.google.samples.apps.iosched.po;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;

/**
 * Created by xke on 9/16/15.
 */
abstract class MyPageObject {
    protected static final long ACTION_TIMEOUT = 2000;
    private UiDevice mDevice;

    public MyPageObject(UiDevice uiDevice){
        mDevice = uiDevice;
    }

    protected UiDevice getDevice() {
        return mDevice;
    }

    protected void sendKeys(UiObject textField, String text) throws UiObjectNotFoundException {
        textField.click();
        textField.setText(text);
        mDevice.pressBack();
    }

    public void back() {
        mDevice.pressBack();
    }
}
