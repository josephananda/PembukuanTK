package com.jadeappstudio.pembukuantk.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jadeappstudio.pembukuantk.model.CustomerItemResponse
import com.jadeappstudio.pembukuantk.repo.CustomerRepository

class CustomerViewModel : ViewModel() {
    private var customerRepository = CustomerRepository()

    fun getCustomer(context: Context): LiveData<CustomerItemResponse>{
        return customerRepository.getCustomer(context)
    }
}