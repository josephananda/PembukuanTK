package com.jadeappstudio.pembukuantk.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jadeappstudio.pembukuantk.model.ProductItemResponse
import com.jadeappstudio.pembukuantk.repo.InventoryRepository

class InventoryViewModel : ViewModel() {
    private var inventoryRepository = InventoryRepository()

    fun getProduct(context: Context): LiveData<ProductItemResponse> {
        return inventoryRepository.getProduct(context)
    }
}