package com.example.q2; // CHECK YOUR PACKAGE NAME

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNum1, etNum2;
    Button btnAdd, btnSub, btnMul, btnDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Connect Java to XML
        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);

        // 2. Set Click Listeners
        btnAdd.setOnClickListener(v -> calculateAndOpenResult("+"));
        btnSub.setOnClickListener(v -> calculateAndOpenResult("-"));
        btnMul.setOnClickListener(v -> calculateAndOpenResult("*"));
        btnDiv.setOnClickListener(v -> calculateAndOpenResult("/"));
    }

    private void calculateAndOpenResult(String operator) {
        // Get text from inputs
        String strNum1 = etNum1.getText().toString();
        String strNum2 = etNum2.getText().toString();

        // Safety Check: Did the user type numbers?
        if (strNum1.isEmpty() || strNum2.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        double result = 0;

        // Perform Math
        if (operator.equals("+")) result = num1 + num2;
        else if (operator.equals("-")) result = num1 - num2;
        else if (operator.equals("*")) result = num1 * num2;
        else if (operator.equals("/")) {
            if (num2 == 0) {
                Toast.makeText(this, "Cannot divide by zero!", Toast.LENGTH_SHORT).show();
                return;
            }
            result = num1 / num2;
        }

        // 3. Create Intent to go to next activity
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);

        // Pack the data into the intent
        intent.putExtra("NUMBER_1", num1);
        intent.putExtra("NUMBER_2", num2);
        intent.putExtra("OPERATOR", operator);
        intent.putExtra("RESULT", result);

        // Go!
        startActivity(intent);
    }
}