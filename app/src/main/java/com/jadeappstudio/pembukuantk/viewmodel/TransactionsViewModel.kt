package com.jadeappstudio.pembukuantk.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jadeappstudio.pembukuantk.model.GetInvoiceResponseModel
import com.jadeappstudio.pembukuantk.model.ProductItemResponse
import com.jadeappstudio.pembukuantk.repo.InventoryRepository
import com.jadeappstudio.pembukuantk.repo.TransactionsRepository

class TransactionsViewModel : ViewModel() {
    private var transactionsRepository = TransactionsRepository()

    fun getInvoice(context: Context): LiveData<GetInvoiceResponseModel> {
        return transactionsRepository.getInvoice(context)
    }
}