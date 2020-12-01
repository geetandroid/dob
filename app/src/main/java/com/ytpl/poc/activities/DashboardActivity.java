package com.ytpl.poc.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.ytpl.poc.R;
import com.ytpl.poc.utils.Const;

import java.io.FileInputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btnMVPDemo)
    Button btnMVPDemo;

    @BindView(R.id.btnSignature)
    Button btnSignature;

    @BindView(R.id.btnUpload)
    Button btnUpload;

    @BindView(R.id.imageViewSignature)
    ImageView imageViewSignature;

    @BindView(R.id.frameLayoutImage)
    FrameLayout frameLayout;

    @BindView(R.id.imgBtnDelete)
    ImageButton imageBtnDelete;

    Bitmap signatureBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        btnMVPDemo.setOnClickListener(this);
        btnSignature.setOnClickListener(this);
        btnUpload.setOnClickListener(this);
        imageBtnDelete.setOnClickListener(this);
        frameLayout.setVisibility(View.INVISIBLE);
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
            startActivityForResult(intent, 2);
            //startActivity(intent);
        }
        else if(v.getId() == R.id.btnUpload){
            Intent intent = new Intent(this, UploadDocumentActivity.class);
            startActivity(intent);
        }
        else if(v.getId() == R.id.imgBtnDelete){
            signatureBitmap = null;
            imageViewSignature.setImageBitmap(signatureBitmap);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 2){
            frameLayout.setVisibility(View.VISIBLE);


//            Bitmap bitmap =data.getParcelableExtra("image");
//            imageViewSignature.setImageBitmap(bitmap);

            signatureBitmap = null;
            String filename =data.getStringExtra("image");
            try {
                FileInputStream is = this.openFileInput(filename);
                signatureBitmap = BitmapFactory.decodeStream(is);
                is.close();
                imageViewSignature.setImageBitmap(signatureBitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}