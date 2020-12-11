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

class CustomerRepository {
    private lateinit var apiService: ApiService
    private lateinit var sessionManager: SessionManager

    fun addCustomer(customerName: String, customerPhone: String, customerEmail: String, customerAddress: String, context: Context): MutableLiveData<AddCustomerResponseModel>{
        sessionManager = SessionManager(context)
        val finalResponse = MutableLiveData<AddCustomerResponseModel>()
        val apiClient = ApiClient()
        apiService = apiClient.create(context)
        val customer = CustomerModel(customerName, customerPhone, customerEmail, customerAddress)
        val userType = sessionManager.fetchUserTypeId()
        if (userType == 1) {
            apiService.addCustomerAdmin("${sessionManager.fetchAuthToken()}", customer)
                .enqueue(object : Callback<AddCustomerResponseModel> {
                    override fun onResponse(
                        call: Call<AddCustomerResponseModel>,
                        response: Response<AddCustomerResponseModel>
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

                    override fun onFailure(call: Call<AddCustomerResponseModel>, t: Throwable) {
                        finalResponse.value = null
                    }
                })
            return finalResponse
        } else {
            apiService.addCustomer("${sessionManager.fetchAuthToken()}", customer)
                .enqueue(object : Callback<AddCustomerResponseModel> {
                    override fun onResponse(
                        call: Call<AddCustomerResponseModel>,
                        response: Response<AddCustomerResponseModel>
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

                    override fun onFailure(call: Call<AddCustomerResponseModel>, t: Throwable) {
                        finalResponse.value = null
                    }
                })
            return finalResponse
        }
    }

    fun getCustomer(context: Context): MutableLiveData<CustomerItemResponse> {
        sessionManager = SessionManager(context)
        val finalResponse = MutableLiveData<CustomerItemResponse>()
        val apiClient = ApiClient()
        apiService = apiClient.create(context)
        val userType = sessionManager.fetchUserTypeId()
        if(userType == 1) {
            apiService.getCustomersAdmin("${sessionManager.fetchAuthToken()}")
                .enqueue(object : Callback<CustomerItemResponse> {
                    override fun onResponse(
                        call: Call<CustomerItemResponse>,
                        response: Response<CustomerItemResponse>
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

                    override fun onFailure(call: Call<CustomerItemResponse>, t: Throwable) {
                        finalResponse.value = null
                    }
                })
            return finalResponse
        } else {
            apiService.getCustomers("${sessionManager.fetchAuthToken()}")
                .enqueue(object : Callback<CustomerItemResponse> {
                    override fun onResponse(
                        call: Call<CustomerItemResponse>,
                        response: Response<CustomerItemResponse>
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

                    override fun onFailure(call: Call<CustomerItemResponse>, t: Throwable) {
                        finalResponse.value = null
                    }
                })
            return finalResponse
        }
    }

    fun editCustomer(customerId: Int, customerName: String, customerPhone: String, customerEmail: String, customerAddress: String, context: Context): MutableLiveData<AddCustomerResponseModel>{
        sessionManager = SessionManager(context)
        val finalResponse = MutableLiveData<AddCustomerResponseModel>()
        val apiClient = ApiClient()
        apiService = apiClient.create(context)
        val customer = EditCustomerModel(customerId, customerName, customerPhone, customerEmail, customerAddress)
        val userType = sessionManager.fetchUserTypeId()
        if (userType == 1) {
            apiService.editCustomerAdmin("${sessionManager.fetchAuthToken()}", customer)
                .enqueue(object : Callback<AddCustomerResponseModel> {
                    override fun onResponse(
                        call: Call<AddCustomerResponseModel>,
                        response: Response<AddCustomerResponseModel>
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

                    override fun onFailure(call: Call<AddCustomerResponseModel>, t: Throwable) {
                        finalResponse.value = null
                    }
                })
            return finalResponse
        } else {
            apiService.editCustomer("${sessionManager.fetchAuthToken()}", customer)
                .enqueue(object : Callback<AddCustomerResponseModel> {
                    override fun onResponse(
                        call: Call<AddCustomerResponseModel>,
                        response: Response<AddCustomerResponseModel>
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

                    override fun onFailure(call: Call<AddCustomerResponseModel>, t: Throwable) {
                        finalResponse.value = null
                    }
                })
            return finalResponse
        }
    }

    fun deleteCustomer(customerId: Int, context: Context): MutableLiveData<DeleteResponseModel>{
        sessionManager = SessionManager(context)
        val finalResponse = MutableLiveData<DeleteResponseModel>()
        val apiClient = ApiClient()
        apiService = apiClient.create(context)
        val customer = DeleteModel(customerId)
        val userType = sessionManager.fetchUserTypeId()
        if (userType == 1) {
            apiService.deleteCustomerAdmin("${sessionManager.fetchAuthToken()}", customer)
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
            apiService.deleteCustomer("${sessionManager.fetchAuthToken()}", customer)
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