package com.ytpl.poc;

import android.app.Application;
import android.content.Context;

import com.ytpl.poc.utils.Const;
import com.ytpl.poc.utils.LocaleHelper;

public class App extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base, Const.LANGUAGE));
    }
}
