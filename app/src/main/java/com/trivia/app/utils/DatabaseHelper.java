package com.trivia.app.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.trivia.app.models.UserData;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";
    private static final String TABLE_NAME= "my_trivia_db";
    public static final String COL1 = "ID";
    public static final String COL2 = "question1";
    public static final String COL3 = "answer1";
    public static final String COL4 = "question2";
    public static final String COL5 = "answer2";
    public static final String COL6 = "question3";
    public static final String COL7 = "answer3";
    public static final String COL8 = "datetime";

    private static final String CREATE_TABLE =
            "CREATE TABLE "+ TABLE_NAME +"("+ COL1+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    COL2 + " TEXT,"+COL3+ " TEXT,"+ COL4 +" TEXT,"+ COL5 +" TEXT,"+ COL6 + " TEXT,"+
                    COL7+ " TEXT," + COL8+ " TEXT)";



    public DatabaseHelper(Context context){
        super(context,TABLE_NAME,null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop = "DROP IF TABLE EXISTS ";
        db.execSQL(drop+TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String q1, String ans1, String q2,
                           String ans2, String q3, String ans3,
                           String datetime){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,q1);
        contentValues.put(COL3,ans1);
        contentValues.put(COL4,q2);
        contentValues.put(COL5,ans2);
        contentValues.put(COL6,q3);
        contentValues.put(COL7,ans3);
        contentValues.put(COL8,datetime);

        Log.d(TAG,"DATA: Adding "+datetime+" to "+TABLE_NAME);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if (result == -1){
            return false;
        }else {
            return true;
        }
    }




    public ArrayList<UserData> getAllDataFromDB() {
        ArrayList<UserData> userDataList = new ArrayList<>();

        // select all query
        String select_query= "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this .getWritableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                UserData userData = new UserData();
                userData.setID(cursor.getInt(cursor.getColumnIndex(COL1)));
                userData.setQuestion1(cursor.getString(cursor.getColumnIndex(COL2)));
                userData.setAnswer1(cursor.getString(cursor.getColumnIndex(COL3)));
                userData.setQuestion2(cursor.getString(cursor.getColumnIndex(COL4)));
                userData.setAnswer2(cursor.getString(cursor.getColumnIndex(COL5)));
                userData.setQuestion3(cursor.getString(cursor.getColumnIndex(COL6)));
                userData.setAnswer3(cursor.getString(cursor.getColumnIndex(COL7)));
                userData.setDateTime(cursor.getString(cursor.getColumnIndex(COL8)));
                userDataList.add(userData);
            }while (cursor.moveToNext());
        }
        return userDataList;
    }
}
