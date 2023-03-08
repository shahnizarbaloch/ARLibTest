package com.shah.myapplication.retrofit


import com.shah.myapplication.model.Medication
import retrofit2.Call
import retrofit2.http.*

interface RetrofitInterface {


    @GET("v3/a7117ef1-1cf8-4b6c-949c-05783b28ce6c")
    fun getMedications(): Call<Medication>

}