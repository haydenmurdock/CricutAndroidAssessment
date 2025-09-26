package com.cricut.androidassessment.ui.data

import java.util.Dictionary

data class Question(val id: Int, val prompt: String, val displayAnswers: MutableMap<String, String>){
/*
    we would use the display answers dictonary to help pass along additional question information to display in the UI
*/
}