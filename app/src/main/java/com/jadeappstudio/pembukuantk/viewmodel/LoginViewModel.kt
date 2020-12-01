package com.jadeappstudio.pembukuantk.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jadeappstudio.pembukuantk.model.LoginResponseModel
import com.jadeappstudio.pembukuantk.repo.AuthRepository
import com.jadeappstudio.pembukuantk.utils.SessionManager


class LoginViewModel : ViewModel() {

    private var authRepository = AuthRepository()

    fun isFormValid(username: String, password: String): String {
        var respon = ""
        if (username == "") {
            respon = "Username Kosong"
        } else if (password == "") {
            respon = "Password Kosong"
        }
        return respon
    }

    fun login(username: String, password: String, context: Context): LiveData<LoginResponseModel?>? {
        return authRepository.login(username, password, context)
    }

    fun saveToken(token: String, context: Context){
        val sessionManager = SessionManager(context)
        sessionManager.saveAuthToken(token)
    }

    fun saveData(userId: Int, userTypeId: Int, username: String, context: Context){
        val sessionManager = SessionManager(context)
        sessionManager.saveUserId(userId)
        sessionManager.saveUserTypeId(userTypeId)
        sessionManager.saveUsername(username)
    }
}