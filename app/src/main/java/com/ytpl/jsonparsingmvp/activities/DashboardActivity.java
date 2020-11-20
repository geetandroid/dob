package com.ytpl.jsonparsingmvp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ytpl.jsonparsingmvp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btnMVPDemo)
    Button btnMVPDemo;

    @BindView(R.id.btnSignature)
    Button btnSignature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        btnMVPDemo.setOnClickListener(this);
        btnSignature.setOnClickListener(this);
    }

//    @OnClick(R.id.btnMVPDemo)
//    public void onClickMVPDemo(){
//        Intent intent = new Intent(this, MoviesListActivity.class);
//        startActivity(intent);
//    }
//
//    @OnClick(R.id.btnSignature)
//    public void onClickSignature(){
//        Intent intent = new Intent(this, SignatureActivity.class);
//        startActivity(intent);
//
//    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnMVPDemo){
            Intent intent = new Intent(this, MoviesListActivity.class);
       startActivity(intent);
        }
        else if(v.getId() == R.id.btnSignature){
            Intent intent = new Intent(this, SignatureActivity.class);
       startActivity(intent);
        }
    }
}