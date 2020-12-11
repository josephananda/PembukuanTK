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
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.jadeappstudio.pembukuantk.db.microservice.ApiClient
import com.jadeappstudio.pembukuantk.db.microservice.ApiService
import com.jadeappstudio.pembukuantk.model.*
import com.jadeappstudio.pembukuantk.utils.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersRepository {
    private lateinit var apiService: ApiService
    private lateinit var sessionManager: SessionManager

    fun addUser(
        username: String,
        password: String,
        context: Context
    ): MutableLiveData<AddUsersResponseModel> {
        sessionManager = SessionManager(context)
        val finalResponse = MutableLiveData<AddUsersResponseModel>()
        val apiClient = ApiClient()
        apiService = apiClient.create(context)
        val newUser = NewUserModel(username, password)
        apiService.addUserAdmin("${sessionManager.fetchAuthToken()}", newUser)
            .enqueue(object : Callback<AddUsersResponseModel> {
                override fun onResponse(
                    call: Call<AddUsersResponseModel>,
                    response: Response<AddUsersResponseModel>
                ) {
                    Log.i("Response: ", "${response.body()}")
                    if (response.isSuccessful) {
                        val responses = response.body()
                        if (!responses?.status.equals("error")) {
                            finalResponse.value = responses
                            return
                        } else {
                            finalResponse.value = null
                        }
                    } else {
                        finalResponse.value = null
                    }
                }

                override fun onFailure(call: Call<AddUsersResponseModel>, t: Throwable) {
                    finalResponse.value = null
                }
            })
        return finalResponse
    }

    fun getUsers(context: Context): MutableLiveData<GetUsersResponseModel> {
        sessionManager = SessionManager(context)
        val finalResponse = MutableLiveData<GetUsersResponseModel>()
        val apiClient = ApiClient()
        apiService = apiClient.create(context)
        apiService.getUsersAdmin("${sessionManager.fetchAuthToken()}")
            .enqueue(object : Callback<GetUsersResponseModel> {
                override fun onResponse(
                    call: Call<GetUsersResponseModel>,
                    response: Response<GetUsersResponseModel>
                ) {
                    Log.i("Response: ", "${response.body()}")
                    if (response.isSuccessful) {
                        val responses = response.body()
                        if (!responses?.status.equals("error")) {
                            finalResponse.value = responses
                            return
                        } else {
                            finalResponse.value = null
                        }
                    } else {
                        finalResponse.value = null
                    }
                }

                override fun onFailure(call: Call<GetUsersResponseModel>, t: Throwable) {
                    finalResponse.value = null
                }
            })
        return finalResponse
    }

    fun editUser(
        userId: Int,
        username: String,
        password: String,
        context: Context
    ): MutableLiveData<AddUsersResponseModel> {
        sessionManager = SessionManager(context)
        val finalResponse = MutableLiveData<AddUsersResponseModel>()
        val apiClient = ApiClient()
        apiService = apiClient.create(context)
        val editUser = EditUserModel(userId, username, password)
        apiService.editUserAdmin("${sessionManager.fetchAuthToken()}", editUser)
            .enqueue(object : Callback<AddUsersResponseModel> {
                override fun onResponse(
                    call: Call<AddUsersResponseModel>,
                    response: Response<AddUsersResponseModel>
                ) {
                    Log.i("Response: ", "${response.body()}")
                    if (response.isSuccessful) {
                        val responses = response.body()
                        if (!responses?.status.equals("error")) {
                            finalResponse.value = responses
                            return
                        } else {
                            finalResponse.value = null
                        }
                    } else {
                        finalResponse.value = null
                    }
                }

                override fun onFailure(call: Call<AddUsersResponseModel>, t: Throwable) {
                    finalResponse.value = null
                }
            })
        return finalResponse
    }

    fun deleteUser(userId: Int, context: Context): MutableLiveData<DeleteResponseModel> {
        sessionManager = SessionManager(context)
        val finalResponse = MutableLiveData<DeleteResponseModel>()
        val apiClient = ApiClient()
        apiService = apiClient.create(context)
        val user = DeleteModel(userId)
        apiService.deleteUser("${sessionManager.fetchAuthToken()}", user)
            .enqueue(object : Callback<DeleteResponseModel> {
                override fun onResponse(
                    call: Call<DeleteResponseModel>,
                    response: Response<DeleteResponseModel>
                ) {
                    Log.i("Response: ", "${response.body()}")
                    if (response.isSuccessful) {
                        val responses = response.body()
                        if (!responses?.status.equals("error")) {
                            finalResponse.value = responses
                            return
                        } else {
                            finalResponse.value = null
                        }
                    } else {
                        finalResponse.value = null
                    }
                }

                override fun onFailure(call: Call<DeleteResponseModel>, t: Throwable) {
                    finalResponse.value = null
                }
            })
        return finalResponse
    }
}