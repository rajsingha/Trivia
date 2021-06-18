package com.trivia.app.viewmodels;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.trivia.app.models.UserData;
import com.trivia.app.utils.DatabaseHelper;
import com.trivia.app.utils.Util;

import java.util.ArrayList;
import java.util.List;

public class UniversalViewModel extends ViewModel  {

    private MutableLiveData<List<UserData>> mutableLiveData;
    List<UserData> userDataList = new ArrayList<>();        // Used for testing purpose.
    UserData userData =new UserData();
    DatabaseHelper databaseHelper;                          //SQLite DB
    String DateTime = Util.INSTANCE.getDateTime();          // Local DATE TIME in string formatted


    public UniversalViewModel(){
        mutableLiveData =new MutableLiveData<>();
    }

    public MutableLiveData<List<UserData>> getMutableLiveDataObserver(){
        return mutableLiveData;
    }

    // Fetch all the data from SQLite DB
    public void fetchDataFromDB(Context context){
        databaseHelper = new DatabaseHelper(context);
        mutableLiveData.postValue(databaseHelper.getAllDataFromDB());
    }

    //Set Question and Answer no.1
    public void setQNA01(String question1, String answer1){
        userData.setQuestion1(question1);
        userData.setAnswer1(answer1);
        userDataList.add(userData);
    }

    //Set Question and Answer no.2
    public void setQNA02(String qn02, String answer02){
        userData.setQuestion2(qn02);
        userData.setAnswer2(answer02);
        userDataList.add(userData);
    }

    //Set Question and Answer no.3
    public void setQNA03(String qna03,String answer03){
        userData.setQuestion3(qna03);
        userData.setAnswer3(answer03);
        userData.setDateTime(DateTime);
        userDataList.add(userData);
    }

    //Set Resetting ArrayList
    public void resetData(){
        userDataList.clear();

    }

    public UserData getTheUserData(){
        return userData;
    }

    // Pushing all the data to db
    public void pushToDB(Context context){

        databaseHelper = new DatabaseHelper(context);
        databaseHelper.addData(
                userData.getQuestion1(),
                userData.getAnswer1(),
                userData.getQuestion2(),
                userData.getAnswer2(),
                userData.getQuestion3(),
                userData.getAnswer3(),
                DateTime
        );
        Log.d("ViewModel", "Pushed to DB successful!");

    }


}

