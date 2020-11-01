package com.jadeappstudio.pembukuantk.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.jadeappstudio.pembukuantk.db.microservice.ApiService
import com.jadeappstudio.pembukuantk.db.microservice.ApiClient
import com.jadeappstudio.pembukuantk.model.LoginModel
import com.jadeappstudio.pembukuantk.model.ResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AuthRepository {
    private lateinit var apiService: ApiService

    fun login(username: String, password: String): MutableLiveData<ResponseModel> {
        val finalResponse = MutableLiveData<ResponseModel>()
        val apiClient = ApiClient()
        apiService = apiClient.create()
        val user = LoginModel(username, password)
        apiService.loginUser(user).enqueue(object : Callback<ResponseModel> {
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                if (response.isSuccessful) {
                    val responses = response.body()
                    if (!responses?.status.equals("error")) {
                        Log.i("token", responses?.data.toString())
                        finalResponse.value = responses
                        return
                    } else {
                        finalResponse.value = null
                    }
                } else {
                    finalResponse.value = null
                }
            }

            override fun onFailure(call: Call<ResponseModel>, error: Throwable) {
                finalResponse.value = null
            }
        })
        return finalResponse
    }
}