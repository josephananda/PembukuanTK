package com.jadeappstudio.pembukuantk.repo

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.jadeappstudio.pembukuantk.db.microservice.ApiClient
import com.jadeappstudio.pembukuantk.db.microservice.ApiService
import com.jadeappstudio.pembukuantk.model.*
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

    fun getProduct(context: Context): MutableLiveData<ProductItemResponse>{
        sessionManager = SessionManager(context)
        val finalResponse = MutableLiveData<ProductItemResponse>()
        val apiClient = ApiClient()
        apiService = apiClient.create(context)
        val userType = sessionManager.fetchUserTypeId()
        if(userType == 1) {
            apiService.getProductAdmin("${sessionManager.fetchAuthToken()}")
                .enqueue(object : Callback<ProductItemResponse> {
                    override fun onResponse(
                        call: Call<ProductItemResponse>,
                        response: Response<ProductItemResponse>
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

                    override fun onFailure(call: Call<ProductItemResponse>, t: Throwable) {
                        finalResponse.value = null
                    }
                })
            return finalResponse
        } else {
            apiService.getProduct("${sessionManager.fetchAuthToken()}")
                .enqueue(object : Callback<ProductItemResponse> {
                    override fun onResponse(
                        call: Call<ProductItemResponse>,
                        response: Response<ProductItemResponse>
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

                    override fun onFailure(call: Call<ProductItemResponse>, t: Throwable) {
                        finalResponse.value = null
                    }
                })
            return finalResponse
        }
    }

    fun addStock(productId: Int, productQuantity: Int, context: Context): MutableLiveData<AddProductStockResponseModel>{
        sessionManager = SessionManager(context)
        val finalResponse = MutableLiveData<AddProductStockResponseModel>()
        val apiClient = ApiClient()
        apiService = apiClient.create(context)
        var userType = sessionManager.fetchUserTypeId()
        val productStock = ProductStockModel(productId, productQuantity, userType)
        if(userType == 1) {
            apiService.addProductStockAdmin("${sessionManager.fetchAuthToken()}", productStock)
                .enqueue(object : Callback<AddProductStockResponseModel> {
                    override fun onResponse(
                        call: Call<AddProductStockResponseModel>,
                        response: Response<AddProductStockResponseModel>
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

                    override fun onFailure(call: Call<AddProductStockResponseModel>, t: Throwable) {
                        finalResponse.value = null
                    }
                })
            return finalResponse
        } else {
            apiService.addProductStock("${sessionManager.fetchAuthToken()}", productStock)
                .enqueue(object : Callback<AddProductStockResponseModel> {
                    override fun onResponse(
                        call: Call<AddProductStockResponseModel>,
                        response: Response<AddProductStockResponseModel>
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

                    override fun onFailure(call: Call<AddProductStockResponseModel>, t: Throwable) {
                        finalResponse.value = null
                    }
                })
            return finalResponse
        }
    }

    fun addInvoice(custId: Int, itemList: MutableList<ItemListInvoice>, context: Context): MutableLiveData<AddInvoiceResponseModel>{
        sessionManager = SessionManager(context)
        val finalResponse = MutableLiveData<AddInvoiceResponseModel>()
        val apiClient = ApiClient()
        apiService = apiClient.create(context)
        var userId = sessionManager.fetchUserId()
        var userTypeId = sessionManager.fetchUserTypeId()
        val addInvoiceModel = AddInvoiceModel(custId, userId, itemList)
        Log.i("INVOICE: ", "$addInvoiceModel")
        if(userTypeId == 1){
            apiService.addInvoiceAdmin("${sessionManager.fetchAuthToken()}", addInvoiceModel)
                .enqueue(object : Callback<AddInvoiceResponseModel>{
                    override fun onResponse(
                        call: Call<AddInvoiceResponseModel>,
                        response: Response<AddInvoiceResponseModel>
                    ) {
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

                    override fun onFailure(call: Call<AddInvoiceResponseModel>, t: Throwable) {
                        finalResponse.value = null
                    }
                })
            return finalResponse
        } else {
            apiService.addInvoice("${sessionManager.fetchAuthToken()}", addInvoiceModel)
                .enqueue(object : Callback<AddInvoiceResponseModel>{
                    override fun onResponse(
                        call: Call<AddInvoiceResponseModel>,
                        response: Response<AddInvoiceResponseModel>
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

                    override fun onFailure(call: Call<AddInvoiceResponseModel>, t: Throwable) {
                        finalResponse.value = null
                    }
                })
            return finalResponse
        }
    }
}