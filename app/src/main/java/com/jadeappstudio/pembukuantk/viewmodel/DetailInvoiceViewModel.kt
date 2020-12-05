package com.jadeappstudio.pembukuantk.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jadeappstudio.pembukuantk.model.InvoiceDetailResp
import com.jadeappstudio.pembukuantk.repo.TransactionsRepository

class DetailInvoiceViewModel : ViewModel() {
    private var transactionsRepository = TransactionsRepository()

    fun getInvoiceDetail(invoiceId: Int, context: Context): LiveData<InvoiceDetailResp> {
        return transactionsRepository.getInvDetail(invoiceId, context)
    }
}