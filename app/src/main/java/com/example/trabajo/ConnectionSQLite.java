package com.example.trabajo;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConnectionSQLite extends SQLiteOpenHelper {
    public ConnectionSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE user\n" +
                        "(\n" +
                        "  id_user bigint NOT NULL,\n" +
                        "  username char(30) NOT NULL,\n" +
                        "  password char(120) NOT NULL,\n" +
                        "  name char(60) NOT NULL,\n" +
                        "  lastname char(60) NOT NULL,\n" +
                        "  email char(120) NOT NULL,\n" +
                        "  dni char(30) NOT NULL,\n" +
                        "  state char(1) NOT NULL,\n" +
                        "  CONSTRAINT PK_User PRIMARY KEY (id_user),\n" +
                        "  CONSTRAINT id_user UNIQUE (id_user)\n" +
                        ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);
    }

}
