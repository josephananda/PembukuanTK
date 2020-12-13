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

    fun login(
        username: String,
        password: String,
        context: Context
    ): LiveData<LoginResponseModel?>? {
        return authRepository.login(username, password, context)
    }

    fun saveToken(token: String, context: Context) {
        val sessionManager = SessionManager(context)
        sessionManager.saveAuthToken(token)
    }

    fun saveData(userId: Int, userTypeId: Int, username: String, context: Context) {
        val sessionManager = SessionManager(context)
        sessionManager.saveUserId(userId)
        sessionManager.saveUserTypeId(userTypeId)
        sessionManager.saveUsername(username)
    }
}