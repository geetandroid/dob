package com.ytpl.jsonparsingmvp.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.ytpl.jsonparsingmvp.R;


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
