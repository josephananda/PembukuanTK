package com.jadeappstudio.pembukuantk.repo

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.jadeappstudio.pembukuantk.db.microservice.ApiClient
import com.jadeappstudio.pembukuantk.db.microservice.ApiService
import com.jadeappstudio.pembukuantk.model.GetInvoiceDetailModel
import com.jadeappstudio.pembukuantk.model.GetInvoiceResponseModel
import com.jadeappstudio.pembukuantk.model.InvoiceDetailResp
import com.jadeappstudio.pembukuantk.utils.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TransactionsRepository {
    private lateinit var apiService: ApiService
    private lateinit var sessionManager: SessionManager

    fun getInvoice(context: Context): MutableLiveData<GetInvoiceResponseModel> {
        sessionManager = SessionManager(context)
        val finalResponse = MutableLiveData<GetInvoiceResponseModel>()
        val apiClient = ApiClient()
        apiService = apiClient.create(context)
        val userType = sessionManager.fetchUserTypeId()
        if (userType == 1) {
            apiService.getInvoiceAdmin("${sessionManager.fetchAuthToken()}")
                .enqueue(object : Callback<GetInvoiceResponseModel> {
                    override fun onResponse(
                        call: Call<GetInvoiceResponseModel>,
                        response: Response<GetInvoiceResponseModel>
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

                    override fun onFailure(call: Call<GetInvoiceResponseModel>, t: Throwable) {
                        finalResponse.value = null
                    }
                })
            return finalResponse
        } else {
            apiService.getInvoice("${sessionManager.fetchAuthToken()}")
                .enqueue(object : Callback<GetInvoiceResponseModel> {
                    override fun onResponse(
                        call: Call<GetInvoiceResponseModel>,
                        response: Response<GetInvoiceResponseModel>
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

                    override fun onFailure(call: Call<GetInvoiceResponseModel>, t: Throwable) {
                        finalResponse.value = null
                    }
                })
            return finalResponse
        }
    }

    fun getInvDetail(invoiceId: Int, context: Context): MutableLiveData<InvoiceDetailResp>{
        sessionManager = SessionManager(context)
        val finalResponse = MutableLiveData<InvoiceDetailResp>()
        val apiClient = ApiClient()
        apiService = apiClient.create(context)
        val userType = sessionManager.fetchUserTypeId()
        var invId = GetInvoiceDetailModel(invoiceId)
        if (userType == 1) {
            apiService.getInvoiceDetailAdmin("${sessionManager.fetchAuthToken()}", invId)
                .enqueue(object : Callback<InvoiceDetailResp> {
                    override fun onResponse(
                        call: Call<InvoiceDetailResp>,
                        response: Response<InvoiceDetailResp>
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

                    override fun onFailure(call: Call<InvoiceDetailResp>, t: Throwable) {
                        finalResponse.value = null
                    }
                })
            return finalResponse
        } else {
            apiService.getInvoiceDetail("${sessionManager.fetchAuthToken()}", invId)
                .enqueue(object : Callback<InvoiceDetailResp> {
                    override fun onResponse(
                        call: Call<InvoiceDetailResp>,
                        response: Response<InvoiceDetailResp>
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

                    override fun onFailure(call: Call<InvoiceDetailResp>, t: Throwable) {
                        finalResponse.value = null
                    }
                })
            return finalResponse
        }
    }
}