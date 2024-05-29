package com.example.roomdb.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.roomdb.data.Converters.Roomconverters
import com.example.roomdb.data.daos.WordDaos
import com.example.roomdb.data.model.Word


@Database(entities = [Word::class], version = 1)
@TypeConverters(Roomconverters::class)
abstract class WordDatabse : RoomDatabase() {

    abstract fun wordDao() : WordDaos

    companion object {


        fun buildDatabase(context : Context) : WordDatabse{
            return Room.databaseBuilder(context,WordDatabse::class.java,"word.db")
                .build()
        }

        @Volatile
        private var INSTANCE : WordDatabse? = null

        fun getDatabase(context: Context) : WordDatabse{
            if(INSTANCE == null){
                synchronized(this){
                    INSTANCE = buildDatabase(context)
                }
            }
            return INSTANCE!!
        }
    }
}