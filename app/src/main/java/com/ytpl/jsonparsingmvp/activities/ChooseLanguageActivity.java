package com.ytpl.jsonparsingmvp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ytpl.jsonparsingmvp.R;
import com.ytpl.jsonparsingmvp.utils.Const;
import com.ytpl.jsonparsingmvp.utils.LocaleHelper;
import com.ytpl.jsonparsingmvp.utils.MyPreference;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChooseLanguageActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btnEnglish)
    Button btnEnglish;

    @BindView(R.id.btnArebic)
    Button btnArebic;

    @BindView(R.id.btnProceed)
    Button btnProceed;

    public MyPreference myPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_language);
        ButterKnife.bind(this);
        btnEnglish.setOnClickListener(this);
        btnArebic.setOnClickListener(this);
        btnProceed.setOnClickListener(this);
        myPref = new MyPreference(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base));
    }

    private void updateLanguage(String lang) {
        myPref.setLanguage(lang);
        Const.LANGUAGE = lang;
        LocaleHelper.setLocale(ChooseLanguageActivity.this, Const.LANGUAGE);
       recreate();


    }
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnProceed){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
        else if(v.getId() == R.id.btnArebic){
            updateLanguage("AR");
        }
        else if(v.getId() == R.id.btnEnglish){
            updateLanguage("EN");
        }
    }
}