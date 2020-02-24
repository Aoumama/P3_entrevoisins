package com.openclassrooms.entrevoisins.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

public class SharedPreferencesUtils {


    /** Instance unique non préinitialisée */
    private static SharedPreferences sharedPreferences = null;
    private static SharedPreferencesUtils INSTANCE = null;

    /** Point d'accès pour l'instance unique du SharedPreferences */
    public static SharedPreferencesUtils getInstance(Context context) {
        if (INSTANCE == null) {
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            INSTANCE = new SharedPreferencesUtils();
        }
        return INSTANCE;
    }


    // check and return key if exists
    public boolean getBooleanPreference(String key) {
        boolean value = false;
        //SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (sharedPreferences != null) {
            value = sharedPreferences.getBoolean(key, false);
        }
        return value;
    }

    // given value to the key
    public void setBooleanPreference(String key, boolean value) {
        //SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (sharedPreferences != null && !TextUtils.isEmpty(key)) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(key, value);
            editor.apply();
        }
    }

    // delete preferences
    public void deletePreference(String key) {
        //SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.apply();
    }

}
