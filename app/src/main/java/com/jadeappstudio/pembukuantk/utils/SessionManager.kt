/*
 * Created by Joseph Ananda Sugihdharma on 12/11/20 11:41 PM .
 * Copyright (c) 2020 . All rights reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

    fun fetchUserId(): Int?{
        return prefs.getInt(USER_ID, 0)
    }
}