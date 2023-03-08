package com.shah.myapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profile")
data class Profile(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    var id:Int = 0,
    @ColumnInfo(name = "email_address")
    var email:String="",
    @ColumnInfo(name = "password")
    var password:String=""
)
