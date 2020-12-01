package com.jadeappstudio.pembukuantk.model

data class AddProductStockResponseModel(
    var status: String? = "",
    var message: String? = "",
    var data: ProductStockResponseModel.ProductStockResponse
)