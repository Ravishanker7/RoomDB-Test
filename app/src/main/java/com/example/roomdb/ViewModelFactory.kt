package com.example.roomdb

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomdb.data.WordRepositery

class ViewModelFactory(private val wordRepositery: WordRepositery) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java )){
            return MainViewModel(wordRepositery) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}