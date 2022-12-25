package com.example.myaccounts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myaccounts.db.DbAccount;

public class AddAccountActivity extends AppCompatActivity {

    private EditText etName, etPassword, etPlatform;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);

        etPlatform = findViewById(R.id.txtPlatform);
        etName = findViewById(R.id.txtName);
        etPassword = findViewById(R.id.txtPassword);

        findViewById(R.id.btnSubmit).setOnClickListener(v -> submit());
    }

    private void submit() {
        if (etPlatform.getText().toString().isEmpty() || etName.getText().toString().isEmpty() || etPassword.getText().toString().isEmpty()){
            Toast.makeText(this, "fill in the fields", Toast.LENGTH_SHORT).show();
        }else {
            DbAccount db = new DbAccount(this);
            long id = db.insertAccount(etPlatform.getText().toString(), etName.getText().toString(), etPassword.getText().toString());

            if (id != -1) {
                Toast.makeText(this, "Saved account", Toast.LENGTH_SHORT).show();
            }

            clearInputs();
        }
    }

    private void clearInputs() {
        etName.setText("");
        etPassword.setText("");
        etPlatform.setText("");
    }
}