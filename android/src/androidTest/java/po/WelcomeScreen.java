package po;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

/**
 * Created by xke on 9/16/15.
 */
public class WelcomeScreen extends MyPageObject {

    UiObject declineButton = new UiObject(new UiSelector().text("Decline").className("android.widget.Button"));
    UiObject acceptButton = new UiObject(new UiSelector().text("Accept").className("android.widget.Button"));

    public WelcomeScreen(UiDevice mDevice) {
        super(mDevice);
    }

    public void accept() throws UiObjectNotFoundException {
        acceptButton.clickAndWaitForNewWindow(ACTION_TIMEOUT);
    }

    public boolean isDisplayed() throws UiObjectNotFoundException {
        return acceptButton.exists() && acceptButton.isClickable();
    }
}
