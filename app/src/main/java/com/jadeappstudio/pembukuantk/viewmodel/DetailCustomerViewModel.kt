package com.jadeappstudio.pembukuantk.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jadeappstudio.pembukuantk.model.DeleteResponseModel
import com.jadeappstudio.pembukuantk.repo.CustomerRepository

class DetailCustomerViewModel: ViewModel() {
    private var customerRepository = CustomerRepository()

    fun deleteCustomer(customerId: Int, context: Context): LiveData<DeleteResponseModel>{
        return customerRepository.deleteCustomer(customerId, context)
    }
}