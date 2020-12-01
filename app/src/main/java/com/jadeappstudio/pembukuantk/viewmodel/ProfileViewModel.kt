package com.jadeappstudio.pembukuantk.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jadeappstudio.pembukuantk.utils.SessionManager

class ProfileViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    fun setTokenEmpty(context: Context){
        val sessionManager = SessionManager(context)
        sessionManager.saveAuthToken("")
    }
}