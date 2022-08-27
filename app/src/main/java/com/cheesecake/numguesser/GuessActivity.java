package com.cheesecake.numguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class GuessActivity extends AppCompatActivity {
    private int mid = 0;
    private int minRange = 0;
    private int maxRange = 0;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        minRange = intent.getIntExtra(MainActivity.MIN_RANGE, 0);
        maxRange = intent.getIntExtra(MainActivity.MAX_RANGE, 1000);
        mid = split(minRange, maxRange);

        // Capture the layout's TextView and set the string as its text
        textView = findViewById(R.id.guessTextView);
        textView.setText(String.valueOf(mid));
    }

    public void update() {
        mid = split(minRange, maxRange);
        textView.setText(String.valueOf(mid));
    }

    public int split(int min, int max) {
        return (max - min + 1) / 2 + min;
    }

    public void smaller(View view) {
        maxRange = mid - 1;
        update();
    }
    public void greater(View view) {
        minRange = mid + 1;
        update();
    }
    public void guessed(View view) {
        Context context = getApplicationContext();
        CharSequence text = "I guessed, didn't tell ya?";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}