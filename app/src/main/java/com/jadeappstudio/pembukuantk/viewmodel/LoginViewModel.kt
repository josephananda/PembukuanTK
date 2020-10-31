package com.jadeappstudio.pembukuantk.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jadeappstudio.pembukuantk.model.ResponseModel
import com.jadeappstudio.pembukuantk.repo.DataRepository


class LoginViewModel : ViewModel() {

    private var dataRepository = DataRepository()

    fun isFormValid(username: String, password: String): String {
        var respon = ""
        if (username == "") {
            respon = "Username Kosong"
        } else if (password == "") {
            respon = "Password Kosong"
        }
        return respon
    }

    fun login(username: String, password: String): LiveData<ResponseModel?>? {
        return dataRepository.login(username, password)
    }
}