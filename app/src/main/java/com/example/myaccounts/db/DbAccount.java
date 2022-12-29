package com.example.myaccounts.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.myaccounts.entities.Account;

import java.util.ArrayList;

public class DbAccount extends DbHelper {

    public DbAccount(@Nullable Context context) {
        super(context);
    }

    public long insertAccount(String platform, String name, String password) {
        long id = -1;

        try {
            SQLiteDatabase db = getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(ACCOUNT_PLATFORM, platform);
            values.put(ACCOUNT_NAME, name);
            values.put(ACCOUNT_PASSWORD, password);

            id = db.insert(TABLE_ACCOUNT, null, values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

    public ArrayList<Account> readAccounts() {
        SQLiteDatabase db = getWritableDatabase();
        ArrayList<Account> listAccounts = new ArrayList<>();
        Account account = null;
        Cursor cursorAccounts = null;

        cursorAccounts = db.rawQuery("SELECT * FROM " + TABLE_ACCOUNT, null);

        if (cursorAccounts.moveToFirst()) {
            do {
                account = new Account();
                account.setId(cursorAccounts.getInt(0));
                account.setPlatform(cursorAccounts.getString(1));
                account.setName(cursorAccounts.getString(2));
                account.setPassword(cursorAccounts.getString(3));
                listAccounts.add(account);
            } while (cursorAccounts.moveToNext());
        }

        return listAccounts;
    }

    public Account readAccounts(int id) {
        SQLiteDatabase db = getWritableDatabase();

        Account account = null;
        Cursor cursorAccounts = null;

        cursorAccounts = db.rawQuery("SELECT * FROM " + TABLE_ACCOUNT + " WHERE id = " + id + " LIMIT 1", null);

        if (cursorAccounts.moveToFirst()) {
            account = new Account();
            account.setId(cursorAccounts.getInt(0));
            account.setPlatform(cursorAccounts.getString(1));
            account.setName(cursorAccounts.getString(2));
            account.setPassword(cursorAccounts.getString(3));
        }

        cursorAccounts.close();

        return account;
    }

    public boolean editAccount(int id,String platform, String name, String password) {

        boolean valid = false;

        SQLiteDatabase db = getWritableDatabase();

        try {
            db.execSQL(" UPDATE " + TABLE_ACCOUNT + " SET platform = '"+ platform +"', name = '"+ name +"', password = '"+ password +"' WHERE id = '"+ id +"'");
            valid = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            valid = false;
        }finally {
            db.close();
        }

        return valid;
    }

    public  boolean deleteAccount(int id){

        boolean valid = false;

        SQLiteDatabase db = getWritableDatabase();

        try {
            db.execSQL("DELETE FROM " + TABLE_ACCOUNT + " WHERE id = '"+ id +"'");
            valid = true;
        } catch (Exception exc) {
            exc.printStackTrace();
            valid = false;
        }finally {
            db.close();
        }

        return valid;
    }
}