package com.jadeappstudio.pembukuantk.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jadeappstudio.pembukuantk.model.AddCustomerResponseModel
import com.jadeappstudio.pembukuantk.repo.CustomerRepository

class AddCustomerViewModel: ViewModel() {
    private var customerRepository = CustomerRepository()

    fun addCustomer(customerName: String, customerPhone: String, customerEmail: String, customerAddress: String, context: Context): LiveData<AddCustomerResponseModel>{
        return customerRepository.addCustomer(customerName, customerPhone, customerEmail, customerAddress, context)
    }
}