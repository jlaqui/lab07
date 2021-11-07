package com.example.trabajo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.trabajo.databinding.ActivityLoginBinding;
import com.example.trabajo.viewmodels.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityLoginBinding activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        activityLoginBinding.setViewModelLogin(new LoginViewModel(this));
        activityLoginBinding.executePendingBindings();
    }
}