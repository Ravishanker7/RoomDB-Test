package com.example.roomdb.data.Converters

import androidx.room.TypeConverter
import java.util.Date

class Roomconverters {

    @TypeConverter
    fun convertdatetoLong(date : Date) : Long{
        return date.time
    }

    @TypeConverter
    fun convertLongtodate(timelong : Long) : Date{
        return Date(timelong)
    }
}