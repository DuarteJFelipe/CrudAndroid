package com.example.myaccounts.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.myaccounts.entities.Accounts;

import java.util.ArrayList;

public class DbAccount extends DbHelper {

    public DbAccount(@Nullable Context context) {
        super(context);
    }

    public long insertAccount(String platform,String name, String password) {
        long id = -1;

        try {
            SQLiteDatabase db = getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(ACCOUNT_PASSWORD, platform);
            values.put(ACCOUNT_NAME, name);
            values.put(ACCOUNT_PASSWORD, password);

            id = db.insert(TABLE_ACCOUNT, null, values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

    public ArrayList<Accounts> readAccounts(){
        SQLiteDatabase db = getWritableDatabase();
        ArrayList<Accounts> listAccounts = new ArrayList<>();
        Accounts accounts = null;
        Cursor cursorAccounts = null;

        cursorAccounts = db.rawQuery("SELECT * FROM " + TABLE_ACCOUNT ,null);

        if(cursorAccounts.moveToFirst()){
            do{
                accounts = new Accounts();
                accounts.setId(cursorAccounts.getInt(0));
                accounts.setPlatform(cursorAccounts.getString(1));
                accounts.setName(cursorAccounts.getString(2));
                accounts.setPassword(cursorAccounts.getString(3));
                listAccounts.add(accounts);
            } while (cursorAccounts.moveToNext());
        }

        return listAccounts;
    }
}































