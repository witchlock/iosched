package com.google.samples.apps.iosched.po;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;

/**
 * Created by xke on 9/16/15.
 */
public class SessionListScreen extends MyPageObject {

    private UiSelector firstSessionSelector = new UiSelector().className("android.widget.ListView").className("android.widget.LinearLayout").instance(0);

    public SessionListScreen(UiDevice uiDevice) {
        super(uiDevice);
    }

    public UiObject getTopSession() {
        return new UiObject(firstSessionSelector);
    }

    public void scrollUpAndDown() throws UiObjectNotFoundException {
        UiScrollable scrollable = new UiScrollable(new UiSelector().className("android.widget.ListView"));
        scrollable.scrollForward();
        scrollable.scrollForward();
        scrollable.scrollBackward();
    }

    public void clickSession(UiObject session) throws UiObjectNotFoundException {
        session.clickAndWaitForNewWindow();
    }

    public void sortSessionByTheme(String themeName) throws UiObjectNotFoundException {
        String sortEntryText = "All Sessions";
        selectOptionFromSortEntry(themeName, sortEntryText);
    }

    public void sortSessionByTopics(String topic) throws UiObjectNotFoundException {
        String sortEntryText = "All Topics";
        selectOptionFromSortEntry(topic, sortEntryText);
    }

    private void selectOptionFromSortEntry(String optionText, String sortEntryText) throws UiObjectNotFoundException {
        UiObject topSortDropdown = new UiObject(new UiSelector().text(sortEntryText));
        topSortDropdown.clickAndWaitForNewWindow();
        UiObject option = new UiObject(new UiSelector().text(optionText));
        option.clickAndWaitForNewWindow();
    }
}
