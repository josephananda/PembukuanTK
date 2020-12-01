package com.jadeappstudio.pembukuantk.utils

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context){
    private var prefs: SharedPreferences = context.getSharedPreferences("PembukuanTK", Context.MODE_PRIVATE)

    companion object {
        const val USER_TOKEN = "user_token"
        const val USER_ID = "user_id"
        const val USER_TYPE_ID = "user_type_id"
        const val USERNAME = "username"
    }

    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    fun fetchAuthToken(): String? {
        return prefs.getString(USER_TOKEN, null)
    }

    fun saveUserId(userId: Int){
        val editor = prefs.edit()
        editor.putInt(USER_ID, userId)
        editor.apply()
    }

    fun saveUserTypeId(userTypeId: Int){
        val editor = prefs.edit()
        editor.putInt(USER_TYPE_ID, userTypeId)
        editor.apply()
    }

    fun saveUsername(username: String){
        val editor = prefs.edit()
        editor.putString(USERNAME, username)
        editor.apply()
    }

    fun fetchUserTypeId(): Int? {
        return prefs.getInt(USER_TYPE_ID, 0)
    }
}