package com.jadeappstudio.pembukuantk.db.microservice

import com.jadeappstudio.pembukuantk.model.AddProductResponseModel
import com.jadeappstudio.pembukuantk.model.LoginModel
import com.jadeappstudio.pembukuantk.model.LoginResponseModel
import com.jadeappstudio.pembukuantk.model.ProductModel
import com.jadeappstudio.pembukuantk.utils.Constants
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @POST(Constants.LOGIN_URL)
    fun loginUser(@Body info: LoginModel): Call<LoginResponseModel>

    @POST(Constants.ADD_PRODUCT_URL)
    fun addProduct(@Header("Authorization") token: String, @Body product: ProductModel): Call<AddProductResponseModel>
}