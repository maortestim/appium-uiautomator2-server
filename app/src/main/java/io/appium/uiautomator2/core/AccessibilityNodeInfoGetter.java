package io.appium.uiautomator2.core;

import android.support.test.uiautomator.Configurator;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.view.accessibility.AccessibilityNodeInfo;

import static io.appium.uiautomator2.utils.ReflectionUtils.invoke;
import static io.appium.uiautomator2.utils.ReflectionUtils.method;

/**
 * Static helper class for getting {@link AccessibilityNodeInfo} instances.
 */
public abstract class AccessibilityNodeInfoGetter {

    private static Configurator configurator = Configurator.getInstance();

    /**
     * Gets the {@link AccessibilityNodeInfo} associated with the given {@link UiObject2}
     */
    public static AccessibilityNodeInfo fromUiObject(Object object) {
        if (object instanceof UiObject2) {
            return (AccessibilityNodeInfo) invoke(method(UiObject2.class, "getAccessibilityNodeInfo"), object);
        } else if (object instanceof UiObject) {
            return (AccessibilityNodeInfo) invoke(method(UiObject.class, "findAccessibilityNodeInfo"), object);
        } else {
            throw new RuntimeException("Unknown object type: " + object.getClass().getName());
        }
    }
}