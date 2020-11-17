package com.jadeappstudio.pembukuantk.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.jadeappstudio.pembukuantk.utils.SessionManager

class SplashViewModel: ViewModel() {
    fun checkToken(context: Context): String{
        val sessionManager = SessionManager(context)
        val token = sessionManager.fetchAuthToken()
        return token.toString()
    }
}