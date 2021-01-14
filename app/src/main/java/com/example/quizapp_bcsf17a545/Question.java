package com.example.quizapp_bcsf17a545;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Question extends AppCompatActivity {

    TextView textview;
    Button next, quit;
    RadioGroup radio_group;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "1) What is the language of the Quran?",
            "2) Who was the first prophet of Allah (s.w.t.)?",
            "3) Believing in Allah (s.w.t.) , in His angels, in His books, in His messengers, in the last day, in destiny and in life after death means a Muslim has …",
            "4) What is the meaning of An-Nas ?",
            "5) A prophet is called .......... in Arabic",
            "6) How many Allah (s.w.t.)'s are there ?",
            "7) What is the first month of the Islamic Calendar?",
            "8) What is Salat?",
            "9) What is the count of Rashidun Caliphate?",
            "10) What is the count of Surah in Quran"
    };
    String choices[] = {
            "English" , "Arabic" , "Urdu" , "Hebrew",
            "Nuh (a.s.)","Hud (a.s.)","Adam (a.s.)","Musa (a.s.)",
            "Ihsan","Taqwa","Islam","Iman",
            "The dawn","The opening","The people","The night",
            "Nabi","Rasul","Both a and b","None of the above",
            "Three","Two","One","Zero",
            "Muharram","Ramadan","Shawwal","Rabi-ul-Awal",
            "Fasting","Giving to the poor","Praying","Pilgrimage",
            "One","Four","Three","Two",
            "112","116","115","114"
    };
    String answers[] = {"Arabic",
            "Adam (a.s.)",
            "Iman",
            "The people",
            "Both a and b",
            "One",
            "Muharram",
            "Praying",
            "Four",
            "114"};
    int flag=0;
    public static int marks=0,correct=0,wrong=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);


        next=(Button)findViewById(R.id.next_button);
        quit=(Button)findViewById(R.id.quit_button);
        textview=(TextView) findViewById(R.id.tvque);
        radio_group=(RadioGroup)findViewById(R.id.answersGrp);
        rb1=(RadioButton)findViewById(R.id.rd);
        rb2=(RadioButton)findViewById(R.id.rd2);
        rb3=(RadioButton)findViewById(R.id.rd3);
        rb4=(RadioButton)findViewById(R.id.rd4);
        textview.setText(questions[flag]);
        rb1.setText(choices[0]);
        rb2.setText(choices[1]);
        rb3.setText(choices[2]);
        rb4.setText(choices[3]);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(radio_group.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_group.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();

                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }
                flag++;
                if(flag<questions.length)
                {
                    textview.setText(questions[flag]);
                    rb1.setText(choices[flag*4]);
                    rb2.setText(choices[flag*4 +1]);
                    rb3.setText(choices[flag*4 +2]);
                    rb4.setText(choices[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ScoreBoard.class);
                    startActivity(in);
                }
                radio_group.clearCheck();
            }
        });

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ScoreBoard.class);
                startActivity(intent);
            }
        });
    }
}