package com.example.trabajo.viewmodels;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.databinding.BaseObservable;

import com.example.trabajo.LoginActivity;

public class MainViewModel extends BaseObservable {
    private Context context;

    public MainViewModel(Context context) {
        this.context = context;
    }

    public void onShowLogin() {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }
}
