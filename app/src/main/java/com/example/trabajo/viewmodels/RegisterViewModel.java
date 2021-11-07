package com.example.trabajo.viewmodels;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.trabajo.ConnectionSQLite;
import com.example.trabajo.LoginActivity;
import com.example.trabajo.MainActivity;
import com.example.trabajo.model.User;

public class RegisterViewModel extends BaseObservable {
    private User user;
    private Context context;

    public RegisterViewModel(Context context) {
        user = new User();
        this.context = context;
    }

    /*
    *
    * private String username, password, name, lastname, email, dni;
    * */

    public void setUserUsername(String username) {user.setUsername(username);}
    public void setUserPassword(String password) {user.setPassword(password);}
    public void setUserName(String name) {user.setName(name);}
    public void setUserLastname(String lastname) {user.setLastname(lastname);}
    public void setUserEmail(String email) {user.setEmail(email);}
    public void setUserDni(String dni) {user.setDni(dni);}

    @Bindable
    public String getUserUsername() {return user.getUsername();}
    @Bindable
    public String getUserPassword() {return user.getPassword();}
    @Bindable
    public String getUserName() {return user.getName();}
    @Bindable
    public String getUserLastname() {return user.getLastname();}
    @Bindable
    public String getUserEmail() {return user.getEmail();}
    @Bindable
    public String getUserDni() {return user.getDni();}

    public void onClickRegister() {
        ConnectionSQLite conn = new ConnectionSQLite(context.getApplicationContext(), "bd_trabajoapp", null, 1, null);
        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id_user", 12345);
        contentValues.put("username", user.getUsername());
        contentValues.put("password", user.getPassword());
        contentValues.put("name", user.getName());
        contentValues.put("lastname", user.getLastname());
        contentValues.put("email", user.getEmail());
        contentValues.put("dni", user.getDni());
        contentValues.put("state", 1);
        String _name = user.getName();

        Long id = db.insert("user", "id_user", contentValues);
        Toast.makeText(context.getApplicationContext(), "Successful", Toast.LENGTH_SHORT).show();
        db.close();

        String res = "";
        ConnectionSQLite c = new ConnectionSQLite(context.getApplicationContext(), "bd_trabajoapp", null, 1, null);
        SQLiteDatabase bd = c.getReadableDatabase();

        Cursor cursor = bd.rawQuery(" SELECT*FROM user WHERE id_user = ?", new String[]{"12345"});

        if (!cursor.moveToLast()) Log.i("Error", "Error");
        else {
            cursor.moveToLast();
            res += "id: " + cursor.getInt(0) + "\n";
            res += "username: " + cursor.getString(1) + "\n";
            res += "password: " + cursor.getString(2) + "\n";
        }

        Log.i("Consulta", res);

        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);

    }


}
