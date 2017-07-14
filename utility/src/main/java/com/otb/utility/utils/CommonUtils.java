package com.otb.utility.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.net.URL;


/**
 * Created by Mohit Rajput on 4/7/17.
 * This class provides common utility methods to use in app
 */

public class CommonUtils {

    /**
     * Check if internet is running or not.
     *
     * @param context
     * @return true if internet is available, false if not.
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }


    /**
     * Set maximum input length in an EditText. It's dynamic form of android:maxLength="@integer/maxLength" XML attribute.
     *
     * @param editText
     * @param maxLength
     */
    public static void setMaxLength(EditText editText, int maxLength) {
        InputFilter[] fArray = new InputFilter[1];
        fArray[0] = new InputFilter.LengthFilter(maxLength);
        editText.setFilters(fArray);
    }

    /**
     * Replacement of repeated if-else while setting text in a TextView with null check. Method sets given text in given textView if text is not null. Sets defValue if null.
     *
     * @param textView
     * @param text
     * @param defValue
     */
    public static void setTextInTextView(TextView textView, String text, String defValue) {
        if (!TextUtils.isEmpty(text)) {
            textView.setText(text);
        } else {
            textView.setText(defValue);
        }
    }

    /**
     * This method returns version code of your code
     *
     * @param context
     * @return versionCode of app
     */
    public static int getVersionCode(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (Exception e) {
            throw new RuntimeException("Could not get package name: " + e);
        }
    }

    /**
     * This method returns version code of your code
     *
     * @param context
     * @return versionName of app
     */
    public static String getVersionName(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName;
        } catch (Exception e) {
            throw new RuntimeException("Could not get package name: " + e);
        }
    }

    /**
     * Methods forces keyboard to hide
     *
     * @param activity
     */
    public static void hideKeyboard(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /**
     * Fetches image from a URL and decode it into bitmap.
     *
     * @param imageUrl
     * @return Bitmap image
     */
    public static Bitmap getBitmapFromUrl(String imageUrl) {
        URL url = null;
        try {
            if (imageUrl != null && !imageUrl.isEmpty()) {
                url = new URL(imageUrl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Bitmap image = null;
        try {
            if (url != null) {
                image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }

    /**
     * Converts given sp dimension in px.
     *
     * @param context
     * @param sp
     * @return converted dimension in pixels
     */
    public static float spToPx(Context context, float sp) {
        final float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return sp * scale;
    }

    /**
     * Deletes given directory from device
     *
     * @param directory
     * @return true is deleted, false otherwise
     */
    public static boolean deleteDir(File directory) {
        if (directory != null && directory.isDirectory()) {
            String[] children = directory.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(directory, children[i]));
                if (!success) {
                    return false;
                }
            }
        }

        return directory.delete();
    }

    /**
     * Converts given dp dimension in px.
     *
     * @param context
     * @param dp
     * @return converted dimension in pixels
     */
    public int dpToPx(Context context, int dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }
}
