package com.jadeappstudio.pembukuantk.model

data class CustomerItemResponse(
    var status: String? = "",
    var message: String? = "",
    var data: List<CustomerItemListResponse>
)