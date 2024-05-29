package com.example.roomdb.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.roomdb.data.model.Word


@Dao
interface WordDaos {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Insertword(word : Word) : Long

    @Insert
    suspend fun InsertListofWords(word : List<Word>) : List<Long>

    @Update(onConflict = OnConflictStrategy.ABORT)
    suspend fun Deleteword(word : Word) : Int

    @Delete
    suspend fun DeleteWord(word: Word) : Int

    @Query("select * from Word")
    suspend fun getAllwords() : List<Word>

}