package com.example.quizapp_bcsf17a545;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class Question extends AppCompatActivity {

    TextView countdown,ques;
    Button ch1,ch2,ch3,ch4,next;
    CountDownTimer tm;
    View v;
    boolean isClicked = false;
    String txt;
    int counter,qIndex;
    Ques q;
    int correct=0,wrong=0;
    ArrayList<Ques> arr=new ArrayList<Ques>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        countdown=findViewById(R.id.timer);
        ques=findViewById(R.id.quesField);
        ch1=findViewById(R.id.rd);
        ch2=findViewById(R.id.rd2);
        ch3=findViewById(R.id.rd3);
        ch4=findViewById(R.id.rd4);
        next=findViewById(R.id.next_button);

        arr.add(new Ques("What is the language of the Quran?","English" , "Arabic" , "Urdu" , "Hebrew","Arabic"));
        arr.add(new Ques("Who was the first prophet of Allah (s.w.t.)?","Nuh (a.s.)","Hud (a.s.)","Adam (a.s.)","Musa (a.s.)","Adam (a.s.)"));
        arr.add(new Ques("What is the count of Prophets?","124","112","142","132","124"));
        arr.add(new Ques("What is the meaning of An-Nas ?","The dawn","The opening","The people","The night","The people"));
        arr.add(new Ques("A prophet is called .......... in Arabic","Nabi","Rasul","Both a and b","None of the above","Both a and b"));
        arr.add(new Ques("How many Allah (s.w.t.)'s are there ?","Three","Two","One","Zero","One"));
        arr.add(new Ques("What is the first month of the Islamic Calendar?","Muharram","Ramadan","Shawwal","Rabi-ul-Awal","Muharram"));
        arr.add(new Ques("What is Salat?","Fasting","Giving to the poor","Praying","Pilgrimage","Praying"));
        arr.add(new Ques("What is the count of Rashidun Caliphate?","One","Four","Three","Two","Four"));
        arr.add(new Ques("What is the count of Surah in Quran","112","116","115","114","114"));
        Collections.shuffle(arr);
        counter=0;
        countdown.setText("" +10);
        setData(counter);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isClicked==true)
                {
                    Log.i("bool", "onClick: "+isClicked);
                    ClickNext(view,txt,qIndex);
                }
                else
                {
                    Log.i("bool", "else: "+isClicked);
                    ClickNext(v,"Nothing",0);
                }


            }
        });

        tm= new CountDownTimer(10*1000,1000)
        {
            @Override
            public void onTick(long l) {
                countdown.setText(String.format("%d", l / 1000));
            }

            @Override
            public void onFinish() {
                Toast.makeText(Question.this, "Time Over", Toast.LENGTH_SHORT).show();

                ClickNext(v,"Nothing",0);
            }
        };
    }
    public  void setData(final int val)
    {
        final Ques obj=arr.get(val);
        if (tm!=null)
        {
            tm.start();
        }
        ques.setText("#"+(val+1)+" "+obj.getQuestion());
        ch1.setText(obj.getOpt1());
        ch2.setText(obj.getOpt2());
        ch3.setText(obj.getOpt3());
        ch4.setText(obj.getOpt4());
        ch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isClicked=true;
                txt = ch1.getText().toString();
                qIndex = val;

            }
        });

        ch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isClicked=true;
                txt=ch2.getText().toString();
                qIndex=val;

            }
        });

        ch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isClicked=true;
                txt=ch3.getText().toString();
                qIndex=val;
            }
        });

        ch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isClicked=true;
                txt=ch4.getText().toString();
                qIndex=val;
            }
        });

    }
    public void newActivity(View view,int val,int total,int wrong)
    {
        Intent intent = new Intent(this,ScoreBoard.class);
        String result="Correct: "+val+"\n"+"Wrong: "+wrong+"";
        intent.putExtra("Result",result);
        startActivity(intent);

    }
    public void ClickNext(View view,String clickedButtonText,int questionIndex)
    {
        final Ques q=arr.get(questionIndex);

        if(counter<(arr.size()-1))
        {
            if(txt.equals(q.getAnswer())) {
                correct++;
            }
            else {
                wrong++;
            }

            tm.cancel();
            isClicked=false;
            counter++;
            setData(counter);
            if(counter==(arr.size()-1)){
                next.setText("Finish");
            }
        }

        else {

            if (txt.equals(q.getAnswer())) {
                correct++;
            } else {
                wrong++;
            }
            tm.cancel();

            Toast.makeText(Question.this, "Questions are completed", Toast.LENGTH_SHORT).show();
            newActivity(view, correct, arr.size(), wrong);
        }
    }
}