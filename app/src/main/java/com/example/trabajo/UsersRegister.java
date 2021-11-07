package com.example.trabajo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.trabajo.databinding.ActivityUsersRegisterBinding;
import com.example.trabajo.viewmodels.UsersRegisterViewModel;

public class UsersRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUsersRegisterBinding activityUsersRegisterBinding = DataBindingUtil.setContentView(this, R.layout.activity_users_register);
        activityUsersRegisterBinding.setViewModelUsersRegister(new UsersRegisterViewModel(this));
        activityUsersRegisterBinding.executePendingBindings();
    }
}