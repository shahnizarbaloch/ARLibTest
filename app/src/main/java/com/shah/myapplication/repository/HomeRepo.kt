package com.shah.myapplication.repository


import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shah.myapplication.BaseApplication
import com.shah.myapplication.model.Medication
import com.shah.myapplication.model.MedicationItem
import com.shah.myapplication.model.Profile
import com.shah.myapplication.retrofit.RetrofitClient
import com.shah.myapplication.room_database.MyRoomDatabase
import com.shah.myapplication.room_database.dao.ProfileDAO
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepo @Inject constructor (@ApplicationContext appContext: Context) {


    companion object {
        private lateinit var dao: ProfileDAO
        private var isLoading: MutableLiveData<Boolean> = MutableLiveData(true)
        private var medicationListMutableLiveData: MutableLiveData<MutableList<MedicationItem>> = MutableLiveData()
    }

    init {

        val database = MyRoomDatabase.getInstance(appContext)
        dao = database?.profileDAO()!!

    }


    fun getIsLoading(): LiveData<Boolean> {
        return isLoading
    }


    fun getMedicationList(): MutableLiveData<MutableList<MedicationItem>> {

        val topDestinationList:MutableList<MedicationItem> = ArrayList()
        val call = RetrofitClient.instance?.api?.getMedications()
        call?.enqueue(object : Callback<Medication> {
            override fun onResponse(call: Call<Medication>, response: Response<Medication>) {
                isLoading.value = false
                if (response.code() == 200) {
                    response.body().let {
                        topDestinationList.addAll(response.body()!!)
                        medicationListMutableLiveData.value = topDestinationList

                    }

                }
            }

            override fun onFailure(call: Call<Medication>, t: Throwable) {
                isLoading.value = false

            }
        })
        return medicationListMutableLiveData
    }

    fun insertProfile(obj: Profile) {
        dao.insertProfile(obj)
    }
}