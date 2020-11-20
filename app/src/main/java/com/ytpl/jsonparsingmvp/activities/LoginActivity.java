package com.ytpl.jsonparsingmvp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.ytpl.jsonparsingmvp.utils.EncUtil;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.ytpl.jsonparsingmvp.R;
import com.ytpl.jsonparsingmvp.utils.LocaleHelper;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    @BindView(R.id.tlUsername)
    TextInputLayout tlUsername;

    @BindView(R.id.edtUsername)
    TextInputEditText edtUsername;

    @BindView(R.id.tlPassword)
    TextInputLayout tlPassword;

    @BindView(R.id.edtPassword)
    TextInputEditText edtPassword;

    @BindView(R.id.action_1)
    Button action1;


    @BindView(R.id.btnLogin)
    Button btnLogin;

    @BindView(R.id.result_text)
    TextView resultText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
       
        action1.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        EncUtil.generateKey(getApplicationContext());
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base));
    }


    private void ShortToast(String s) {
        Toast.makeText(getApplicationContext(),s, Toast.LENGTH_SHORT).show();
    }

    public void setTextInputLayoutError(TextInputLayout e, String error, Boolean errorEnabled){
        e.setError(error);
        e.setErrorEnabled(errorEnabled);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.action_1){
            if(action1.getTag().equals("e")){
                if(edtUsername.getText().toString().trim().isEmpty()){
                    setTextInputLayoutError(tlUsername,getString(R.string.error_username),true);
                    return;
                }
                if(edtPassword.getText().toString().trim().isEmpty()){
                    setTextInputLayoutError(tlPassword, getString(R.string.error_password), true);
                }
                setTextInputLayoutError(tlUsername,null,false);
                setTextInputLayoutError(tlPassword,null,false);

                JSONObject request = null;
                try {
                    request = new JSONObject();
                    request.put("username", edtUsername.getText().toString());
                    request.put("password", edtPassword.getText().toString());
                }catch(JSONException exception)
                {
                    Log.e("LoginActivity",exception.toString());
                }
                resultText.setText(EncUtil.encrypt(getApplicationContext(),request.toString()));
                action1.setTag("d");
                action1.setText("DECRYPT USING APP INSTANCE");
            }else{
                if(resultText.getText().toString().isEmpty()){
                    ShortToast("empty data to decrypt");
                    return;
                }
                resultText.setText(EncUtil.decrypt(getApplicationContext(),resultText.getText().toString()));
                action1.setTag("e");
                action1.setText("ENCRYPT USING APP INSTANCE");
            }
        }
        else if(view.getId() == R.id.btnLogin){

            Intent intent = new Intent(this, DashboardActivity.class);
            startActivity(intent);

        }
    }
}
