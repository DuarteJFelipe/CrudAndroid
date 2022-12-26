package com.example.myaccounts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.myaccounts.adapters.ListAccountsAdapter;
import com.example.myaccounts.db.DbAccount;
import com.example.myaccounts.entities.Account;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView listAccounts;
    ArrayList<Account> listArrayAccounts;
    DbAccount dbAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listAccounts = findViewById(R.id.listAccounts);
        listAccounts.setLayoutManager(new LinearLayoutManager(this));

        dbAccount = new DbAccount(MainActivity.this);
        listArrayAccounts = new ArrayList<>();

        findViewById(R.id.btnGoSubmit).setOnClickListener(v -> {
            Intent intent = new Intent(this,AddAccountActivity.class);

            startActivity(intent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        ListAccountsAdapter adapter = new ListAccountsAdapter(dbAccount.readAccounts());
        listAccounts.setAdapter(adapter);
    }
}