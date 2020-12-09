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

    fun addUser(username: String, password: String, context: Context): MutableLiveData<AddUsersResponseModel>{
        sessionManager = SessionManager(context)
        val finalResponse = MutableLiveData<AddUsersResponseModel>()
        val apiClient = ApiClient()
        apiService = apiClient.create(context)
        val newUser = NewUserModel(username, password)
        apiService.addUserAdmin("${sessionManager.fetchAuthToken()}", newUser).enqueue(object : Callback<AddUsersResponseModel>{
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

    fun editUser(userId: Int, username: String, password: String, context: Context): MutableLiveData<AddUsersResponseModel>{
        sessionManager = SessionManager(context)
        val finalResponse = MutableLiveData<AddUsersResponseModel>()
        val apiClient = ApiClient()
        apiService = apiClient.create(context)
        val editUser = EditUserModel(userId, username, password)
        apiService.editUserAdmin("${sessionManager.fetchAuthToken()}", editUser).enqueue(object : Callback<AddUsersResponseModel>{
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
}