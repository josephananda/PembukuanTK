package com.jadeappstudio.pembukuantk.db.microservice

import com.jadeappstudio.pembukuantk.model.*
import com.jadeappstudio.pembukuantk.utils.Constants
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @POST(Constants.LOGIN_URL)
    fun loginUser(@Body info: LoginModel): Call<LoginResponseModel>

    @POST(Constants.ADD_PRODUCT_URL)
    fun addProduct(@Header("Authorization") token: String, @Body product: ProductModel): Call<AddProductResponseModel>

    @GET(Constants.GET_PRODUCT_ADMIN_URL)
    fun getProductAdmin(@Header("Authorization") token: String): Call<ProductItemResponse>

    @GET(Constants.GET_PRODUCT_URL)
    fun getProduct(@Header("Authorization") token: String): Call<ProductItemResponse>

    @POST(Constants.ADD_PRODUCT_STOCK_ADMIN_URL)
    fun addProductStockAdmin(@Header("Authorization") token: String, @Body productStock: ProductStockModel): Call<AddProductStockResponseModel>

    @POST(Constants.ADD_PRODUCT_STOCK_URL)
    fun addProductStock(@Header("Authorization") token: String, @Body productStock: ProductStockModel): Call<AddProductStockResponseModel>
}