package com.jadeappstudio.pembukuantk.db.microservice

import com.jadeappstudio.pembukuantk.model.LoginModel
import com.jadeappstudio.pembukuantk.model.ResponseModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    fun loginUser(@Body info: LoginModel): Call<ResponseModel>
}