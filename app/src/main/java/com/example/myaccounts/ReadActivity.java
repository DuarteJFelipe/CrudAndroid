package com.example.myaccounts;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myaccounts.db.DbAccount;
import com.example.myaccounts.entities.Account;

public class ReadActivity extends AppCompatActivity {

    EditText txtName, txtPlatform, txtPassword;
    Button btnSubmit, btnDelete;
    boolean valid = false;
    Account account;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        txtPlatform = findViewById(R.id.txtPlatform);
        txtName = findViewById(R.id.txtName);
        txtPassword = findViewById(R.id.txtPassword);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnDelete = findViewById(R.id.btnDelete);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                id = Integer.parseInt(null);
            } else {
                id = extras.getInt("ID");
            }
        } else {
            id = (int) savedInstanceState.getSerializable("ID");
        }

        DbAccount dbAccount = new DbAccount(ReadActivity.this);
        account = dbAccount.readAccounts(id);

        if (account != null) {
            txtPlatform.setText(account.getPlatform());
            txtName.setText(account.getName());
            txtPassword.setText(account.getPassword());
        }

        btnSubmit.setOnClickListener(v -> {
            if (!txtPlatform.getText().toString().equals("") && !txtName.getText().toString().equals("") && !txtPassword.getText().toString().equals("")) {
                valid = dbAccount.editAccount(id, txtPlatform.getText().toString(), txtName.getText().toString(), txtPassword.getText().toString());
                if (valid) {
                    Toast.makeText(ReadActivity.this, "Successfully updated", Toast.LENGTH_SHORT).show();
                    ReadRegister();
                } else {
                    Toast.makeText(ReadActivity.this, "Update Error", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(ReadActivity.this, "Enter all fields", Toast.LENGTH_SHORT).show();
            }
        });

        btnDelete.setOnClickListener(v -> {
            valid = dbAccount.deleteAccount(id);
            if (valid) {
                Toast.makeText(ReadActivity.this, "Successfully Deleted", Toast.LENGTH_SHORT).show();
                ReadRegister();
            } else {
                Toast.makeText(ReadActivity.this, "Delete Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void ReadRegister() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}