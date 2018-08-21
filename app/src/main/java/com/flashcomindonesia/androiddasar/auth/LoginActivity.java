package com.flashcomindonesia.androiddasar.auth;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.flashcomindonesia.androiddasar.main.MainActivity;
import com.flashcomindonesia.androiddasar.R;
import com.flashcomindonesia.androiddasar.model.User;

/**
 * Created by kakaroto on 14/08/18.
 */
public class LoginActivity extends AppCompatActivity {

    private final String TAG = LoginActivity.class.getSimpleName();
    private TextView tvContent;
    private EditText etEmail, etPassword;
    private Button btnOk, btnGoMain;
    public final static String KEY_EMAIL = "key-email";
    public final static String KEY_PASSWORD = "key-password";
    public final static String KEY_USER = "user";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvContent = findViewById(R.id.tv_content);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnOk = findViewById(R.id.btn_ok);
        btnGoMain = findViewById(R.id.btn_go_main);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                if (email.isEmpty()) {
                    etEmail.setError("Email harus diisi !");
                    etEmail.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    etEmail.setError("Email tidak valid");
                    etEmail.requestFocus();
                    return;
                }

                if (password.isEmpty()) {
                    etPassword.setError("password tidak boleh kosong");
                    etPassword.requestFocus();
                    return;
                }
                if (password.length() < 6) {
                    etPassword.setError("password minimal 6");
                    etPassword.requestFocus();
                    return;
                }
                tvContent.setText(email + " - " + password);
            }
        });

        btnGoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                User user = new User(email, password);
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
 /*               intent.putExtra(KEY_EMAIL, email);
                intent.putExtra(KEY_PASSWORD, password);*/
                intent.putExtra(KEY_USER, user);
                startActivity(intent);
            }
        });

        Log.d(TAG, "onCreate: is called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: is called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: is called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: is called");
        btnOk.setBackgroundColor(Color.BLACK);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: is called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: is called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: is called");
    }
}
