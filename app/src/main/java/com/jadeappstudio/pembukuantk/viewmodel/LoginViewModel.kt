package com.jadeappstudio.pembukuantk.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jadeappstudio.pembukuantk.model.ResponseModel
import com.jadeappstudio.pembukuantk.repo.DataRepository


class LoginViewModel: ViewModel(){

    private var dataRepository = DataRepository()

    fun login(username: String, password: String): LiveData<ResponseModel?>? {
        return dataRepository.login(username, password)
    }
}