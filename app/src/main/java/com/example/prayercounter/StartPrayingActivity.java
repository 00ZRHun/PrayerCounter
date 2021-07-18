package com.example.prayercounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class StartPrayingActivity extends AppCompatActivity {
    public static final String TIMER = "com.example.prayercounter.TIMER";
    public static final String COUNTER = "com.example.prayercounter.COUNT";

    long timerValue;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_praying);

        // get the intent that start this activity & extract the string
        Intent intent = getIntent();

        // get the value of NAME from prev MainActivity
        String name = intent.getStringExtra(MainActivity.NAME);
        // set the value into the helloXXX TextView
        TextView helloXXXTV = (TextView) findViewById(R.id.textViewHelloXXX);
        helloXXXTV.setText("Hello " + name);

        // get the value of PRAYER_GOAL from prev MainActivity
        String prayerGoal = intent.getStringExtra(MainActivity.PRAYER_GOAL);
        // set the value into currentCount TextView
        TextView currentCountTV = (TextView) findViewById(R.id.textViewCurrentCount);
        //currentCountTV.setText("Current Count: " + prayerGoal);


        TextView timerTV = (TextView) findViewById(R.id.textViewTimer);

        TextView clickMeBtn = findViewById(R.id.buttonClickMe);


        // Count down
        new CountDownTimer(Long.valueOf(prayerGoal)*1000, 1000) {

            public void onTick(long millisUntilFinished) {
                timerValue = millisUntilFinished / 1000;
                timerTV.setText("seconds remaining: " + timerValue);
            }

            public void onFinish() {
                timerTV.setText("done!");
            }
        }.start();


        //clickMeBtn.callOnClick()

        clickMeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentCountTV.setText("Current Count: " + ++counter);
            }
        });
    }

    /** Called when the user taps the End btn */
    public void endPraying(View view) {
        // start new activity by using intent
        Intent startNewActivityIntent = new Intent(this, EndPrayingActivity.class);

        startNewActivityIntent.putExtra(TIMER, timerValue+"");
        startNewActivityIntent.putExtra(COUNTER, counter+"");

        startActivity(startNewActivityIntent);
    }
}