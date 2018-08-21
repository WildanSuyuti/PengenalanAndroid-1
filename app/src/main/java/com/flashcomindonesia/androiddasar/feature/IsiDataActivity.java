package com.flashcomindonesia.androiddasar.feature;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.flashcomindonesia.androiddasar.R;
import com.flashcomindonesia.androiddasar.auth.LoginActivity;
import com.flashcomindonesia.androiddasar.model.User;

public class IsiDataActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    public static final int RESULT_ISI_DATA = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_data);

        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
    }

    public void ok(View view) {

        Intent intent = new Intent();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        User user = new User(email, password);
/*        intent.putExtra("key-email", etEmail.getText().toString());
        intent.putExtra("key-password", etPassword.getText().toString());*/
        intent.putExtra("key-user", user);
        setResult(RESULT_ISI_DATA, intent);
        finish();
    }
}
