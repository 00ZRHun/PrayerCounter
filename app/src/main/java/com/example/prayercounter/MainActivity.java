package com.example.prayercounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String NAME = "com.example.prayercounter.NAME";
    public static final String PRAYER_GOAL = "com.example.prayercounter.PRAYER_GOAL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the start btn */
    public void startPraying(View view) {
        Intent intent = new Intent(this, StartPrayingActivity.class);

        // get the value of name EditText
        EditText name = (EditText) findViewById(R.id.editTextName);
        String nameValue = name.getText().toString();
        intent.putExtra(NAME, nameValue);
        System.out.print(nameValue);

        // get the value of prayerGoal EditText
        EditText prayerGoal = (EditText) findViewById(R.id.editTextPrayerGoal);
        String prayerGoalValue = prayerGoal.getText().toString();
        intent.putExtra(PRAYER_GOAL, prayerGoalValue);

        startActivity(intent);
    }
}