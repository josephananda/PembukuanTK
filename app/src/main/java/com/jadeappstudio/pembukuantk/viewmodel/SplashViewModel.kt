package com.jadeappstudio.pembukuantk.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jadeappstudio.pembukuantk.model.CheckTokenResponseModel
import com.jadeappstudio.pembukuantk.repo.AuthRepository
import com.jadeappstudio.pembukuantk.utils.SessionManager

class SplashViewModel: ViewModel() {
    private var authRepository = AuthRepository()

    fun checkToken(context: Context): String{
        val sessionManager = SessionManager(context)
        val token = sessionManager.fetchAuthToken()
        return token.toString()
    }

    fun checkValid(token: String, context: Context): LiveData<CheckTokenResponseModel>{
        return authRepository.checkValid(token, context)
    }

    fun setDataEmpty(context: Context) {
        val sessionManager = SessionManager(context)
        sessionManager.saveAuthToken("")
        sessionManager.saveUserId(0)
        sessionManager.saveUserTypeId(0)
        sessionManager.saveUsername("")
    }
}