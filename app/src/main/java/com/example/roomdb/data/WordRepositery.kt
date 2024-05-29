package com.example.roomdb.data

import com.example.roomdb.data.model.Word

class WordRepositery(private val wordDatabse: WordDatabse) {

    suspend fun insert(word: Word){
        wordDatabse.wordDao().Insertword(word)
    }

    suspend fun getAllWords() =wordDatabse.wordDao().getAllwords()


}