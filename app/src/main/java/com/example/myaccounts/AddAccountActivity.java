package com.example.myaccounts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myaccounts.db.DbAccount;

public class AddAccountActivity extends AppCompatActivity {

    private EditText etName, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);

        etName = findViewById(R.id.txtName);
        etPassword = findViewById(R.id.txtPassword);

        findViewById(R.id.btnSubmit).setOnClickListener(v -> submit());
    }

    private void submit() {
        DbAccount db = new DbAccount(this);
        long id = db.insertAccount(etName.getText().toString(), etPassword.getText().toString());

        if (id != -1) {
            Toast.makeText(this, "Saved account " + id, Toast.LENGTH_SHORT).show();
        }

        clearInputs();
    }

    private void clearInputs() {
        etName.setText("");
        etPassword.setText("");
    }
}