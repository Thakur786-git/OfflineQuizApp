package com.learnoset.offlinequizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    // selectedTopicName will be assigned by a topic name ('java', 'android', 'html', 'php')
    private String selectedTopicName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_activity);

        // Initialize widgets from activity_splash_screen.xml
        final Button startBtn = findViewById(R.id.startQuizBtn);
        final LinearLayout javaLayout = findViewById(R.id.javaLayout);
        final LinearLayout phpLayout = findViewById(R.id.phpLayout);
        final LinearLayout htmlLayout = findViewById(R.id.htmlLayout);
        final LinearLayout androidLayout = findViewById(R.id.androidLayout);

        javaLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // assign java to selectedTopicName
                selectedTopicName = "java";

                // select java layout
                javaLayout.setBackgroundResource(R.drawable.round_back_white_stroke10);

                // de-select other layouts
                phpLayout.setBackgroundResource(R.drawable.round_back_white10);
                htmlLayout.setBackgroundResource(R.drawable.round_back_white10);
                androidLayout.setBackgroundResource(R.drawable.round_back_white10);
            }
        });

        phpLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // assign php to selectedTopicName
                selectedTopicName = "php";

                // select php layout
                phpLayout.setBackgroundResource(R.drawable.round_back_white_stroke10);

                // de-select other layouts
                javaLayout.setBackgroundResource(R.drawable.round_back_white10);
                htmlLayout.setBackgroundResource(R.drawable.round_back_white10);
                androidLayout.setBackgroundResource(R.drawable.round_back_white10);
            }
        });

        htmlLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // assign html to selectedTopicName
                selectedTopicName = "html";

                // select HTML layout
                htmlLayout.setBackgroundResource(R.drawable.round_back_white_stroke10);

                // de-select other layouts
                javaLayout.setBackgroundResource(R.drawable.round_back_white10);
                phpLayout.setBackgroundResource(R.drawable.round_back_white10);
                androidLayout.setBackgroundResource(R.drawable.round_back_white10);
            }
        });

        androidLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // assign android to selectedTopicName
                selectedTopicName = "android";

                // select Android layout
                androidLayout.setBackgroundResource(R.drawable.round_back_white_stroke10);

                // de-select other layouts
                javaLayout.setBackgroundResource(R.drawable.round_back_white10);
                phpLayout.setBackgroundResource(R.drawable.round_back_white10);
                htmlLayout.setBackgroundResource(R.drawable.round_back_white10);
            }
        });


        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /* if user not selected any topic yet then show a Toast message
                 * selectedTopicName will be empty or default value ("") if user not selected any topic yet*/
                if (selectedTopicName.isEmpty()) {
                    Toast.makeText(StartActivity.this, "Please select topic first", Toast.LENGTH_SHORT).show();
                } else {

                    // Create an Object of Intent to open quiz questions screen
                    final Intent intent = new Intent(StartActivity.this, MainActivity.class);

                    //put user entered name and selected topic name to intent for use in next activity
                    intent.putExtra("selectedTopic", selectedTopicName);

                    // call startActivity to open next activity along with data(userName, selectedTopicName)
                    startActivity(intent);

                    finish(); // finish (destroy) this activity
                }
            }
        });
    }
}