package com.otb.utility.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.InputFilter;
import android.widget.EditText;


/**
 * Created by Mohit Rajput on 4/7/17.
 * This class provides common utility methods to use in app
 */

public class CommonUtils {

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }


    public static void setMaxLength(EditText editText, int maxLength) {
        InputFilter[] fArray = new InputFilter[1];
        fArray[0] = new InputFilter.LengthFilter(maxLength);
        editText.setFilters(fArray);
    }

}
