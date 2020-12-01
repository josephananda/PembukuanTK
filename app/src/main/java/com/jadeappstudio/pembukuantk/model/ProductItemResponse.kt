package com.jadeappstudio.pembukuantk.model

data class ProductItemResponse(
    var status: String? = "",
    var message: String? = "",
    var data: List<ProductItemListResponse>
)