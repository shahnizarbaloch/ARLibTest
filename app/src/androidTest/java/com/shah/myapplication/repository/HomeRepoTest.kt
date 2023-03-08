package com.shah.myapplication.repository

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.shah.myapplication.model.Profile
import com.shah.myapplication.room_database.MyRoomDatabase
import com.shah.myapplication.room_database.dao.ProfileDAO
import junit.framework.TestCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.CountDownLatch

@RunWith(AndroidJUnit4::class)
class HomeRepoTest : TestCase(){

    private lateinit var database: MyRoomDatabase
    private lateinit var dao: ProfileDAO

    @Before
    public override fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(context,MyRoomDatabase::class.java).build()
        dao = database.profileDAO()!!
    }

    @After
    fun closeDB(){
        database.close()
    }
}