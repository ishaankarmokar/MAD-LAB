package com.example.lab1_demo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {
    EditText usernameInput;
    EditText passwordInput;
    Button enterButton;
    Button clearButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        usernameInput = findViewById(R.id.et_username);
        passwordInput = findViewById(R.id.et_password);
        enterButton = findViewById(R.id.btn_enter);
        clearButton = findViewById(R.id.btn_clear);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        clearButton.setOnClickListener(v -> {
            usernameInput.setText("");
            passwordInput.setText("");

            Toast.makeText(MainActivity.this, "Username and password cleared", Toast.LENGTH_SHORT).show();
        });

        enterButton.setOnClickListener(v -> {

            String username = usernameInput.getText().toString();
            String password = passwordInput.getText().toString();

            if (username.equals("ishaan") && password.equals("password")) {
                Toast.makeText(MainActivity.this, "Password verified for " + username, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}