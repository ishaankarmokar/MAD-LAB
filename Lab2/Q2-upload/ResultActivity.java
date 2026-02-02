package com.example.q2; // CHECK YOUR PACKAGE NAME

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView tvResult = findViewById(R.id.tvFinalResult);
        Button btnBack = findViewById(R.id.btnBack);

        // 1. Get the Intent that started this activity
        Intent intent = getIntent();

        // 2. Unpack the data (using the same keys we used in MainActivity)
        double num1 = intent.getDoubleExtra("NUMBER_1", 0);
        double num2 = intent.getDoubleExtra("NUMBER_2", 0);
        String op = intent.getStringExtra("OPERATOR");
        double result = intent.getDoubleExtra("RESULT", 0);

        // 3. Format the string: "Num1 op Num2 = Result"
        // We use String.format for cleaner decimal places
        String finalString = String.format("%.2f %s %.2f = %.2f", num1, op, num2, result);

        // 4. Set the text
        tvResult.setText(finalString);

        // 5. Back Button Logic
        btnBack.setOnClickListener(v -> {
            // "finish()" destroys this activity and reveals the one underneath (Main)
            finish();
        });
    }
}