package com.jadeappstudio.pembukuantk.repo

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.jadeappstudio.pembukuantk.db.microservice.ApiService
import com.jadeappstudio.pembukuantk.db.microservice.ApiClient
import com.jadeappstudio.pembukuantk.model.LoginModel
import com.jadeappstudio.pembukuantk.model.LoginResponseModel
import com.jadeappstudio.pembukuantk.utils.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AuthRepository {
    private lateinit var apiService: ApiService
    private lateinit var sessionManager: SessionManager

    fun login(username: String, password: String, context: Context): MutableLiveData<LoginResponseModel> {
        sessionManager = SessionManager(context)
        val finalResponse = MutableLiveData<LoginResponseModel>()
        val apiClient = ApiClient()
        apiService = apiClient.create(context)
        val user = LoginModel(username, password)
        apiService.loginUser(user).enqueue(object : Callback<LoginResponseModel> {
            override fun onResponse(call: Call<LoginResponseModel>, response: Response<LoginResponseModel>) {
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
}