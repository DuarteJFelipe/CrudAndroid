package com.example.myaccounts.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbAccount extends DbHelper {

    public DbAccount(@Nullable Context context) {
        super(context);
    }

    public long insertAccount(String name, String password) {
        long id = -1;

        try {
            SQLiteDatabase db = getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(ACCOUNT_NAME, name);
            values.put(ACCOUNT_PASSWORD, password);

            id = db.insert(TABLE_ACCOUNT, null, values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }
}































