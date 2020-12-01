package com.jadeappstudio.pembukuantk.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jadeappstudio.pembukuantk.model.AddProductStockResponseModel
import com.jadeappstudio.pembukuantk.repo.InventoryRepository

class AddProductStockViewModel: ViewModel() {
    private var inventoryRepository = InventoryRepository()

    fun addStock(productId: Int, productQuantity: Int, context: Context): LiveData<AddProductStockResponseModel>{
        return inventoryRepository.addStock(productId, productQuantity, context)
    }
}