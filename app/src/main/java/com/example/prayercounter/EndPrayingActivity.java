package com.example.prayercounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EndPrayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_praying);

        Intent getPrevActData = getIntent();
        String counter = getPrevActData.getStringExtra(StartPrayingActivity.COUNTER);
        String timer = getPrevActData.getStringExtra(StartPrayingActivity.TIMER);

        TextView xNYTV = (TextView) findViewById(R.id.textViewXnY);
        xNYTV.setText("You have prayed " +counter+ " times over the span of " +timer+ " Seconds. Click Ok to navigate back to the main page.");
    }

    /** Called when the user taps the Ok btn */
    public void backToHome(View view) {
        Intent backToHomeIntent = new Intent(this, MainActivity.class);

        startActivity(backToHomeIntent);
    }

}