package com.jadeappstudio.pembukuantk.model

object ProductStockResponseModel {
    data class ProductStockResponse(
        var id: Int? = 0,
        var product_id: Int? = 0,
        var quantity: Int? = 0,
        var user_id: Int? = 0
    )
}