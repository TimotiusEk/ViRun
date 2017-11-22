package com.example.timotiusek.runcompanionvr.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.timotiusek.runcompanionvr.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {
    private TextView signUpLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        signUpLink = (TextView) findViewById(R.id.sign_up_link);

        signUpLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });
        getSupportActionBar().setTitle("Login Page");
    }

    @OnClick(R.id.sign_in_btn)
    public void signIn(){
        startActivity(new Intent(this, MainActivity.class));
    }

}
