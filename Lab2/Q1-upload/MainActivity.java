package com.example.q1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int score = 0;
    private TextView scoreTextView;
    private Button pointButton;

    // We need a unique "Key" (like a password) to label our saved data
    private static final String SCORE_KEY = "CURRENT_SCORE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTextView = findViewById(R.id.scoreText);
        pointButton = findViewById(R.id.btnPoints);

        // --- THE FIX PART 1: RESTORE ---
        // Check if there is a "Time Capsule" (Bundle) from a previous life
        if (savedInstanceState != null) {
            // Get the score out using the key
            score = savedInstanceState.getInt(SCORE_KEY);
            // Update the text immediately so the user never sees "0"
            scoreTextView.setText("Score: " + score);
            showStatus("Restored score: " + score);
        } else {
            showStatus("onCreate - Fresh Start");
        }

        pointButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score++;
                scoreTextView.setText("Score: " + score);
            }
        });
    }

//    // --- THE FIX PART 2: SAVE ---
//    // This runs right before the activity might be destroyed (like on rotation)
//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        // Save the current score into the "Time Capsule"
//        outState.putInt(SCORE_KEY, score);
//        showStatus("onSaveInstanceState - Saved Score: " + score);
//
//        // Always call the superclass last
//        super.onSaveInstanceState(outState);
//    }

    // --- STANDARD LIFECYCLE METHODS ---
    @Override protected void onStart() { super.onStart(); showStatus("onStart - App Visible"); }
    @Override protected void onResume() { super.onResume(); showStatus("onResume - App ready to use"); }
    @Override protected void onPause() { super.onPause(); showStatus("onPause - App paused"); }
    @Override protected void onStop() { super.onStop(); showStatus("onStop - App Hidden"); }
    @Override protected void onDestroy() { super.onDestroy(); showStatus("onDestroy - App Closed"); }

    private void showStatus(String message) {
        Log.d("Lifecycle", message);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}