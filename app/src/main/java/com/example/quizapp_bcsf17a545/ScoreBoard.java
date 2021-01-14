package com.example.quizapp_bcsf17a545;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreBoard extends AppCompatActivity {

    TextView correctans;
    TextView wrongans;
    Button Restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);

        correctans = (TextView) findViewById(R.id.sc_field);
        wrongans=(TextView) findViewById(R.id.wrong_ans);
        Restart = (Button) findViewById(R.id.restart_button);


        StringBuffer sb3 = new StringBuffer();
        StringBuffer sb4 = new StringBuffer();
        sb3.append("Your Final Score\n Correct Answers: " + Question.correct + "\n");
        sb4.append(" Wrong Answers: "+Question.wrong+"\n");

        correctans.setText(sb3);
        wrongans.setText(sb4);

        Question.correct = 0;
        Question.wrong = 0;

        Restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(in);
            }
        });
    }
}