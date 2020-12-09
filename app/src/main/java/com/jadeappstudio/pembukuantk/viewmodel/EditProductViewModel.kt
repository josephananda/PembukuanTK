package com.jadeappstudio.pembukuantk.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jadeappstudio.pembukuantk.model.AddProductResponseModel
import com.jadeappstudio.pembukuantk.repo.InventoryRepository

class EditProductViewModel: ViewModel() {
    private var inventoryRepository = InventoryRepository()

    fun editProduct(productId: Int, productName: String, productPrice: String, context: Context): LiveData<AddProductResponseModel?> {
        return inventoryRepository.editProduct(productId, productName, productPrice, context)
    }
}