package com.jadeappstudio.pembukuantk.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jadeappstudio.pembukuantk.model.GetStatisticsResponse
import com.jadeappstudio.pembukuantk.repo.DashboardRepository

class DashboardViewModel : ViewModel() {
    private val dashboardRepository = DashboardRepository()

    fun getStatistics(context: Context): LiveData<GetStatisticsResponse>{
        return dashboardRepository.getStatistics(context)
    }
}