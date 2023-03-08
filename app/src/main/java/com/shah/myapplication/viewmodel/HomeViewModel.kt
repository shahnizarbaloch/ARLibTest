package com.shah.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import com.shah.myapplication.model.MedicationItem
import com.shah.myapplication.model.Profile
import com.shah.myapplication.repository.HomeRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class HomeViewModel @Inject constructor(private var mRepo:HomeRepo) : ViewModel() {

    val medicationListLive: LiveData<MutableList<MedicationItem>>
        get() = mRepo.getMedicationList()

    val loadingLive: LiveData<Boolean>
        get() = mRepo.getIsLoading()

    fun insertProfile(profile: Profile){
        mRepo.insertProfile(profile)
    }
}