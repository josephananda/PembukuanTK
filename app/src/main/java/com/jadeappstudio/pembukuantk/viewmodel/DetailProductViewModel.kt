package com.jadeappstudio.pembukuantk.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jadeappstudio.pembukuantk.model.DeleteResponseModel
import com.jadeappstudio.pembukuantk.repo.InventoryRepository

class DetailProductViewModel: ViewModel() {
    private var inventoryRepository = InventoryRepository()

    fun deleteProduct(productId: Int, context: Context): LiveData<DeleteResponseModel>{
        return inventoryRepository.deleteProduct(productId, context)
    }
}