package com.jadeappstudio.pembukuantk.model

data class ContactItemResponse(
    var status: String? = "",
    var message: String? = "",
    var data: List<ContactItemListResponse>
)