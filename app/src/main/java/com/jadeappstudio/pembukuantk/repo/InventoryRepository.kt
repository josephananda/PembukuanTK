package com.jadeappstudio.pembukuantk.repo

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.jadeappstudio.pembukuantk.db.microservice.ApiClient
import com.jadeappstudio.pembukuantk.db.microservice.ApiService
import com.jadeappstudio.pembukuantk.model.AddProductResponseModel
import com.jadeappstudio.pembukuantk.model.LoginResponseModel
import com.jadeappstudio.pembukuantk.model.ProductModel
import com.jadeappstudio.pembukuantk.utils.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InventoryRepository {
    private lateinit var apiService: ApiService
    private lateinit var sessionManager: SessionManager

    fun addProduct(productName: String, productPrice: String, context: Context): MutableLiveData<AddProductResponseModel>{
        sessionManager = SessionManager(context)
        val finalResponse = MutableLiveData<AddProductResponseModel>()
        val apiClient = ApiClient()
        apiService = apiClient.create(context)
        val product = ProductModel(productName, productPrice)
        apiService.addProduct("${sessionManager.fetchAuthToken()}", product).enqueue(object : Callback<AddProductResponseModel>{
            override fun onResponse(
                call: Call<AddProductResponseModel>,
                response: Response<AddProductResponseModel>
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

            override fun onFailure(call: Call<AddProductResponseModel>, t: Throwable) {
                finalResponse.value = null
            }
        })
        return finalResponse
    }
}