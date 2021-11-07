package com.example.trabajo.viewmodels;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.databinding.BaseObservable;

import com.example.trabajo.LoginActivity;
import com.example.trabajo.RegisterActivity;

public class LoginViewModel extends BaseObservable {
    private Context context;

    public LoginViewModel(Context context) {
        this.context = context;
    }

    public void onLogin() {
        Log.i("Button", "Verificar datos");
    }

    public void onShowRegister() {
        Intent intent = new Intent(context, RegisterActivity.class);
        context.startActivity(intent);
    }
}
