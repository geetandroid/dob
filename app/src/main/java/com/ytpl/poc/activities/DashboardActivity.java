package com.ytpl.poc.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ytpl.poc.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btnMVPDemo)
    Button btnMVPDemo;

    @BindView(R.id.btnSignature)
    Button btnSignature;

    @BindView(R.id.btnUpload)
    Button btnUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        btnMVPDemo.setOnClickListener(this);
        btnSignature.setOnClickListener(this);
        btnUpload.setOnClickListener(this);
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
        else if(v.getId() == R.id.btnUpload){
            Intent intent = new Intent(this, UploadDocumentActivity.class);
            startActivity(intent);
        }
    }
}