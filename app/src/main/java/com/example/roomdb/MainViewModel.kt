package com.example.roomdb

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdb.data.WordDatabse
import com.example.roomdb.data.WordRepositery
import com.example.roomdb.data.model.Word
import kotlinx.coroutines.launch

class MainViewModel constructor(private val wordRepositery: WordRepositery) : ViewModel(){

    fun getAllWords()=viewModelScope.launch {
        val words=wordRepositery.getAllWords()
    }


    fun addWord(word : String)= viewModelScope.launch{
        val wordObject= Word(word = word)
        wordRepositery.insert(wordObject)
    }


}