package com.jadeappstudio.pembukuantk.model

object ProductResponseModel {
    data class ProductResponse(
        var id: Int? = 0,
        var name: String? = "",
        var price: String? = ""
    )
}