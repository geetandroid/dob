package com.ytpl.jsonparsingmvp;

import android.app.Application;
import android.content.Context;

import com.ytpl.jsonparsingmvp.utils.Const;
import com.ytpl.jsonparsingmvp.utils.LocaleHelper;

public class App extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base, Const.LANGUAGE));
    }
}
