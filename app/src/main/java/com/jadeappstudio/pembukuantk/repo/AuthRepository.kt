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

package com.jadeappstudio.pembukuantk.repo

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.jadeappstudio.pembukuantk.db.microservice.ApiClient
import com.jadeappstudio.pembukuantk.db.microservice.ApiService
import com.jadeappstudio.pembukuantk.model.CheckTokenModel
import com.jadeappstudio.pembukuantk.model.CheckTokenResponseModel
import com.jadeappstudio.pembukuantk.model.LoginModel
import com.jadeappstudio.pembukuantk.model.LoginResponseModel
import com.jadeappstudio.pembukuantk.utils.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AuthRepository {
    private lateinit var apiService: ApiService
    private lateinit var sessionManager: SessionManager

    fun login(
        username: String,
        password: String,
        context: Context
    ): MutableLiveData<LoginResponseModel> {
        sessionManager = SessionManager(context)
        val finalResponse = MutableLiveData<LoginResponseModel>()
        val apiClient = ApiClient()
        apiService = apiClient.create(context)
        val user = LoginModel(username, password)
        apiService.loginUser(user).enqueue(object : Callback<LoginResponseModel> {
            override fun onResponse(
                call: Call<LoginResponseModel>,
                response: Response<LoginResponseModel>
            ) {
                if (response.isSuccessful) {
                    val responses = response.body()
                    if (!responses?.status.equals("error")) {
                        finalResponse.value = responses
                        sessionManager.saveAuthToken(responses?.data?.token.toString())
                        return
                    } else {
                        finalResponse.value = null
                    }
                } else {
                    finalResponse.value = null
                }
            }

            override fun onFailure(call: Call<LoginResponseModel>, error: Throwable) {
                finalResponse.value = null
            }
        })
        return finalResponse
    }

    fun checkValid(token: String, context: Context): MutableLiveData<CheckTokenResponseModel> {
        sessionManager = SessionManager(context)
        val finalResponse = MutableLiveData<CheckTokenResponseModel>()
        val apiClient = ApiClient()
        apiService = apiClient.create(context)
        val check = CheckTokenModel(token)
        apiService.checkValid(check).enqueue(object : Callback<CheckTokenResponseModel> {
            override fun onResponse(
                call: Call<CheckTokenResponseModel>,
                response: Response<CheckTokenResponseModel>
            ) {
                if (response.isSuccessful) {
                    val responses = response.body()
                    finalResponse.value = responses
                } else {
                    finalResponse.value = null
                }
            }

            override fun onFailure(call: Call<CheckTokenResponseModel>, error: Throwable) {
                finalResponse.value = null
            }
        })
        return finalResponse
    }
}