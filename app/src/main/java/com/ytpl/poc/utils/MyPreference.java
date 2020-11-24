package com.ytpl.poc.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import com.ytpl.poc.R;


public class MyPreference {

    private SharedPreferences mPrefrence;
    private SharedPreferences.Editor editor;

    @SuppressLint("CommitPrefEdits")

    public MyPreference(Context context) {
        mPrefrence = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);
        editor = mPrefrence.edit();
    }




    public void setLanguage(String str) {
        editor.putString("Language", str);
        editor.apply();
    }



}
