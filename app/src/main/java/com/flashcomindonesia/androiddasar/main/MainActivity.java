package com.flashcomindonesia.androiddasar.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.flashcomindonesia.androiddasar.R;
import com.flashcomindonesia.androiddasar.feature.IsiDataActivity;
import com.flashcomindonesia.androiddasar.feature.inbox.InboxActivity;
import com.flashcomindonesia.androiddasar.model.User;
import com.flashcomindonesia.androiddasar.auth.LoginActivity;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();
    private TextView tvEmail, tvPassword;
    private final int REQUEST_QODE = 5;

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

        if (user != null) {
            tvEmail.setText(user.getEmail());
            tvPassword.setText(user.getPassword());
        }

    }

    public void goIsiData(View view) {
        startActivityForResult(new Intent(MainActivity.this, IsiDataActivity.class), REQUEST_QODE);
    }

    public void lihatPesan(View view) {
        startActivity(new Intent(MainActivity.this, InboxActivity.class));
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_QODE && resultCode == IsiDataActivity.RESULT_ISI_DATA) {
            User user = data.getParcelableExtra("key-user");
            tvEmail.setText("email: " + user.getEmail());
            tvPassword.setText("password: " + user.getPassword());
        }

    }
}
