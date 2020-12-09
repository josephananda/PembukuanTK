package com.jadeappstudio.pembukuantk.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jadeappstudio.pembukuantk.model.AddCustomerResponseModel
import com.jadeappstudio.pembukuantk.repo.CustomerRepository

class EditCustomerViewModel: ViewModel() {
    private var customerRepository = CustomerRepository()

    fun editCustomer(customerId: Int, customerName: String, customerPhone: String, customerEmail: String, customerAddress: String, context: Context): LiveData<AddCustomerResponseModel> {
        return customerRepository.editCustomer(customerId, customerName, customerPhone, customerEmail, customerAddress, context)
    }
}