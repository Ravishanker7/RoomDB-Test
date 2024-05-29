package com.example.roomdb.data.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.Date


@Entity (indices = [Index (value = ["word"], unique = true)])
data class Word(
    @PrimaryKey(autoGenerate = true) var id : Int=-1,
    var word : String="",
    @Ignore var counter : Int=-1,
    var createdDate : Date=Date()
)
