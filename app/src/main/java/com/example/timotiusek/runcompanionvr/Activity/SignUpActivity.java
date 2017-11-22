package com.example.timotiusek.runcompanionvr.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.timotiusek.runcompanionvr.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle("Registration Page");
    }

    @OnClick(R.id.sign_up_btn)
    public void signUp(){
        Toast.makeText(this, "sign up", Toast.LENGTH_SHORT).show();
    }
}
