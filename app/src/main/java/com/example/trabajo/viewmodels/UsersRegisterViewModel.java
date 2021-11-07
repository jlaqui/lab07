package com.example.trabajo.viewmodels;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.EditText;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.trabajo.ConnectionSQLite;
import com.example.trabajo.RegisterActivity;
import com.example.trabajo.UsersRegister;
import com.example.trabajo.model.User;

public class UsersRegisterViewModel extends BaseObservable {

    private Context context;
    private User user;
    public UsersRegisterViewModel(Context context) {
        user = new User();
        this.context = context;
        ConnectionSQLite c = new ConnectionSQLite(context.getApplicationContext(), "bd_trabajoapp", null, 1, null);
        SQLiteDatabase bd = c.getReadableDatabase();
        Cursor cursor = bd.rawQuery(" SELECT*FROM user WHERE id_user = ?", new String[]{"12345"});
        if (!cursor.moveToLast()) Log.i("ERROR", "ERROR");
        else {
            cursor.moveToLast();
            user.setId(cursor.getInt(0));
            user.setUsername(cursor.getString(1));
            user.setPassword(cursor.getString(2));
            user.setName(cursor.getString(3));
            user.setLastname(cursor.getString(4));
            user.setEmail(cursor.getString(5));
            user.setDni(cursor.getString(6));
            user.setState(Integer.valueOf(cursor.getString(7)));
        }
        bd.close();
    }
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

    public void onUpdateInfo() {

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
        String table_name = "user";
        db.update(table_name, contentValues, "id_user = ?", new String[]{"12345"});
        Intent intent = new Intent(context, UsersRegister.class);
        context.startActivity(intent);
    }

    public void onEliminateInfo() {
        ConnectionSQLite c = new ConnectionSQLite(context.getApplicationContext(), "bd_trabajoapp", null, 1, null);
        SQLiteDatabase bd = c.getReadableDatabase();
        bd.execSQL("DELETE FROM user WHERE id_user = 12345");

        Intent intent = new Intent(context, UsersRegister.class);
        context.startActivity(intent);
    }
}
