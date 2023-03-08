package com.shah.myapplication.room_database.dao

import androidx.room.*
import com.shah.myapplication.model.Profile

@Dao
interface ProfileDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertProfile(profile: Profile)

}