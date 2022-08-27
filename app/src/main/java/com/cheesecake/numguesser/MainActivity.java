package com.cheesecake.numguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String MIN_RANGE = "com.cheesecake.numguesser.MIN_RANGE";
    public static final String MAX_RANGE = "com.cheesecake.numguesser.MAX_RANGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, GuessActivity.class);
        EditText minRangeEditText = (EditText) findViewById(R.id.editTextNumber3);
        EditText maxRangeEditText = (EditText) findViewById(R.id.editTextNumber4);
        int minRange = Integer.parseInt(minRangeEditText.getText().toString());
        int maxRange = Integer.parseInt(maxRangeEditText.getText().toString());
        intent.putExtra(MIN_RANGE, minRange);
        intent.putExtra(MAX_RANGE, maxRange);
        startActivity(intent);
    }
}