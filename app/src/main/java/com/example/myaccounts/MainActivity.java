package com.example.myaccounts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.myaccounts.adapters.ListAccountsAdapter;
import com.example.myaccounts.db.DbAccount;
import com.example.myaccounts.entities.Accounts;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView listAccounts;
    ArrayList<Accounts> listArrayAccounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listAccounts = findViewById(R.id.listAccounts);
        listAccounts.setLayoutManager(new LinearLayoutManager(this));

        DbAccount dbAccount = new DbAccount(MainActivity.this);
        listArrayAccounts = new ArrayList<>();

        ListAccountsAdapter adapter = new ListAccountsAdapter(dbAccount.readAccounts());
        listAccounts.setAdapter(adapter);
        
        findViewById(R.id.btnGoSubmit).setOnClickListener(v -> {
            Intent intent = new Intent(this,AddAccountActivity.class);

            startActivity(intent);
        });
    }
}