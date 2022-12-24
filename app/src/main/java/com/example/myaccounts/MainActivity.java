package com.example.myaccounts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnGoSubmit).setOnClickListener(v -> {
            Intent intent = new Intent(this,AddAccountActivity.class);

            startActivity(intent);
        });
    }
}