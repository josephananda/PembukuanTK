package com.jadeappstudio.pembukuantk.repo

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.jadeappstudio.pembukuantk.db.microservice.ApiClient
import com.jadeappstudio.pembukuantk.db.microservice.ApiService
import com.jadeappstudio.pembukuantk.model.CustomerItemResponse
import com.jadeappstudio.pembukuantk.model.GetStatisticsResponse
import com.jadeappstudio.pembukuantk.model.StatisticYearModel
import com.jadeappstudio.pembukuantk.utils.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class DashboardRepository {

    private lateinit var apiService: ApiService
    private lateinit var sessionManager: SessionManager

    fun getStatistics(context: Context): MutableLiveData<GetStatisticsResponse> {
        sessionManager = SessionManager(context)
        val finalResponse = MutableLiveData<GetStatisticsResponse>()
        val apiClient = ApiClient()
        apiService = apiClient.create(context)
        val userType = sessionManager.fetchUserTypeId()
        val year = StatisticYearModel(Calendar.getInstance().get(Calendar.YEAR).toString())
        if(userType == 1) {
            apiService.getStatisticsAdmin("${sessionManager.fetchAuthToken()}", year)
                .enqueue(object : Callback<GetStatisticsResponse> {
                    override fun onResponse(
                        call: Call<GetStatisticsResponse>,
                        response: Response<GetStatisticsResponse>
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

                    override fun onFailure(call: Call<GetStatisticsResponse>, t: Throwable) {
                        finalResponse.value = null
                    }
                })
            return finalResponse
        } else {
            apiService.getStatistics("${sessionManager.fetchAuthToken()}", year)
                .enqueue(object : Callback<GetStatisticsResponse> {
                    override fun onResponse(
                        call: Call<GetStatisticsResponse>,
                        response: Response<GetStatisticsResponse>
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

                    override fun onFailure(call: Call<GetStatisticsResponse>, t: Throwable) {
                        finalResponse.value = null
                    }
                })
            return finalResponse
        }
    }
}