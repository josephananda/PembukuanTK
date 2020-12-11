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
        val userType = sessionManager.fetchUserTypeId()
        if (userType == 1) {
            apiService.addProductAdmin("${sessionManager.fetchAuthToken()}", product)
                .enqueue(object : Callback<AddProductResponseModel> {
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
        } else {
            apiService.addProduct("${sessionManager.fetchAuthToken()}", product)
                .enqueue(object : Callback<AddProductResponseModel> {
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
        var userId = sessionManager.fetchUserId()
        val productStock = ProductStockModel(productId, productQuantity, userId)
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

    fun editProduct(productId: Int, productName: String, productPrice: String, context: Context): MutableLiveData<AddProductResponseModel>{
        sessionManager = SessionManager(context)
        val finalResponse = MutableLiveData<AddProductResponseModel>()
        val apiClient = ApiClient()
        apiService = apiClient.create(context)
        val product = EditProductModel(productId, productName, productPrice)
        val userType = sessionManager.fetchUserTypeId()
        if (userType == 1) {
            apiService.editProductAdmin("${sessionManager.fetchAuthToken()}", product)
                .enqueue(object : Callback<AddProductResponseModel> {
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
        } else {
            apiService.editProduct("${sessionManager.fetchAuthToken()}", product)
                .enqueue(object : Callback<AddProductResponseModel> {
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

    fun deleteProduct(productId: Int, context: Context): MutableLiveData<DeleteResponseModel>{
        sessionManager = SessionManager(context)
        val finalResponse = MutableLiveData<DeleteResponseModel>()
        val apiClient = ApiClient()
        apiService = apiClient.create(context)
        val product = DeleteModel(productId)
        val userType = sessionManager.fetchUserTypeId()
        if (userType == 1) {
            apiService.deleteProductAdmin("${sessionManager.fetchAuthToken()}", product)
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
        } else {
            apiService.deleteProduct("${sessionManager.fetchAuthToken()}", product)
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
}