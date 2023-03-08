package com.shah.myapplication.room_database

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room
import com.shah.myapplication.model.Profile
import com.shah.myapplication.room_database.dao.ProfileDAO

@Database(
    entities = [Profile::class],
    exportSchema = false,
    version = 1
)
abstract class MyRoomDatabase : RoomDatabase() {

    abstract fun profileDAO(): ProfileDAO?

    companion object {
        private var instance: MyRoomDatabase? = null
        @Synchronized
        fun getInstance(context: Context): MyRoomDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyRoomDatabase::class.java, "ar_lib_test"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }
}