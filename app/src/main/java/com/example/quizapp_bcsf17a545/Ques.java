package com.example.quizapp_bcsf17a545;

import java.util.Collection;

public class Ques {

    String question;
    String ch1,ch2,ch3,ch4;
    String answer;

    public Ques(String question, String ch1, String ch2, String ch3, String ch4, String answer) {
        this.question = question;
        this.ch1 = ch1;
        this.ch2 = ch2;
        this.ch3 = ch3;
        this.ch4 = ch4;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOpt1() {
        return ch1;
    }

    public void setOpt1(String ch1) {
        this.ch1 = ch1;
    }

    public String getOpt2() {
        return ch2;
    }

    public void setOpt2(String ch2) {
        this.ch2 = ch2;
    }

    public String getOpt3() {
        return ch3;
    }

    public void setOpt3(String ch3) {
        this.ch3 = ch3;
    }

    public String getOpt4() {
        return ch4;
    }

    public void setOpt4(String ch4) {
        this.ch4 = ch4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
