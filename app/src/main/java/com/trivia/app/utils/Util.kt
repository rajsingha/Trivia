package com.trivia.app.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.trivia.app.R
import java.text.SimpleDateFormat
import java.util.*

object Util {

    // Used for jumping from the current fragment to next fragment
    fun replaceFragment(context: FragmentActivity,fragment: Fragment){
        val fragmentManager: FragmentManager = context.supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }

    //Organizing the input data
    fun deleteLastComma(string: String):String{
        var sb = StringBuffer(string)
        sb.deleteCharAt(sb.length - 1) // Delete the last character from the string
        return sb.toString()
    }

    // Get the local date and time in  this '15 March 2:00 pm' format.
    fun getDateTime():String{
        val date = Date()
        var dateTime = SimpleDateFormat("dd MMM hh:mm aa")
        var stringDate: String = dateTime.format(date)
        return stringDate

    }
}