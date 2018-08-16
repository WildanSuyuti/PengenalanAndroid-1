package com.flashcomindonesia.androiddasar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.flashcomindonesia.androiddasar.main.LoginActivity;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();
    private TextView tvEmail, tvPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvEmail = findViewById(R.id.tv_email);
        tvPassword = findViewById(R.id.tv_password);
        User user = getIntent().getParcelableExtra(LoginActivity.KEY_USER);
/*        tvEmail.setText(getIntent().getStringExtra(LoginActivity.KEY_EMAIL));
        tvPassword.setText(getIntent().getStringExtra(LoginActivity.KEY_PASSWORD));*/
        tvEmail.setText(user.getEmail());
        tvPassword.setText(user.getPassword());
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

}
