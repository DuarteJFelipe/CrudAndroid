package com.example.myaccounts.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "MyAccounts.db";
    public static final String TABLE_ACCOUNT = "accounts";
    public static final String ACCOUNT_PLATFORM = "platform";
    public static final String ACCOUNT_NAME = "name";
    public static final String ACCOUNT_PASSWORD = "password";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_ACCOUNT + "(" +
                "id integer primary key autoincrement," +
                ACCOUNT_PLATFORM + " text," +
                ACCOUNT_NAME + " text," +
                ACCOUNT_PASSWORD + " text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
