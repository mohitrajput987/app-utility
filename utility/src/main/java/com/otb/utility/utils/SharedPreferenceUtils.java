package com.otb.utility.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Mohit Rajput on 6/7/17.
 * This class creates and manages preferences for this application.
 * It can be used in singleton pattern
 */

public class SharedPreferenceUtils {
    private static String PREFERENCE_NAME = "Preference";
    private static SharedPreferenceUtils sharedPreferenceUtils;
    private SharedPreferences sharedPreferences;

    private SharedPreferenceUtils(Context context) {
        PREFERENCE_NAME = PREFERENCE_NAME + context.getPackageName();
        this.sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    /**
     * It returns singleton object of @{@link SharedPreferenceUtils} class. The best practice is to create its instance once in your Application class and use it everywhere so that you don't need to pass context again.
     *
     * @param context
     * @return Instance of @{@link SharedPreferenceUtils} class
     */
    public static SharedPreferenceUtils getInstance(Context context) {
        if (sharedPreferenceUtils == null) {
            sharedPreferenceUtils = new SharedPreferenceUtils(context);
        }
        return sharedPreferenceUtils;
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, null);
    }

    public String getString(String key, String defVal) {
        return sharedPreferences.getString(key, defVal);
    }

    public void saveString(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public int getInt(String key) {
        return sharedPreferences.getInt(key, 0);
    }

    public int getInt(String key, int defVal) {
        return sharedPreferences.getInt(key, defVal);
    }

    public void saveInt(String key, int value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    public boolean getBoolean(String key, boolean defVal) {
        return sharedPreferences.getBoolean(key, defVal);
    }

    public void saveBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public float getFloat(String key) {
        return sharedPreferences.getFloat(key, 0);
    }

    public float getFloat(String key, float defVal) {
        return sharedPreferences.getFloat(key, defVal);
    }

    public void saveFloat(String key, float value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(key, value);
        editor.commit();
    }

    /**
     * Clear all values from this preference
     */
    public void clear() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    /**
     * Clear value of given key from this preference
     *
     * @param key name of the key whose value to be removed
     */
    public void clear(String key) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.commit();
    }
}
