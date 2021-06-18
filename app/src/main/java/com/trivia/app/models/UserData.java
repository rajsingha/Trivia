package com.trivia.app.models;

public class UserData {

    private int ID;             // The auto increment Id / Game Id
    private String question1;   // What is your name?
    private String answer1;     // Answer01 aka 'Name' of the user
    private String question2;   // Who is the best cricketer in the world?
    private String answer2;     // Answer02
    private String question3;   // What are the colors in the national flag?
    private String answer3;     // Answer03
    private String dateTime;    // Date-Time

    public UserData(){}

    public UserData(int ID, String question1, String answer1, String question2, String answer2, String question3, String answer3, String dateTime) {
        this.ID = ID;
        this.question1 = question1;
        this.answer1 = answer1;
        this.question2 = question2;
        this.answer2 = answer2;
        this.question3 = question3;
        this.answer3 = answer3;
        this.dateTime = dateTime;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getQuestion3() {
        return question3;
    }

    public void setQuestion3(String question3) {
        this.question3 = question3;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
