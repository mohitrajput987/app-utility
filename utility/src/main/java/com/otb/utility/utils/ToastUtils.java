package com.otb.utility.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Mohit Rajput on 5/7/17.
 * This class provides methods to show toast messages
 */

public class ToastUtils {
    /**
     *
     * @param context
     * @param message
     */
    public static void showShortToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /**
     *
     * @param context
     * @param resourceId
     */
    public static void showShortToast(Context context, int resourceId) {
        Toast.makeText(context, context.getString(resourceId), Toast.LENGTH_SHORT).show();
    }

    /**
     *
     * @param context
     * @param message
     */
    public static void showLongToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    /**
     *
     * @param context
     * @param resourceId
     */
    public static void showLongToast(Context context, int resourceId) {
        Toast.makeText(context, context.getString(resourceId), Toast.LENGTH_LONG).show();
    }

    /**
     *
     * @param context
     * @param resourceId
     * @param params
     */
    public static void showLongToast(Context context, int resourceId, Object ...params) {
        Toast.makeText(context, context.getString(resourceId, params), Toast.LENGTH_LONG).show();
    }
}
