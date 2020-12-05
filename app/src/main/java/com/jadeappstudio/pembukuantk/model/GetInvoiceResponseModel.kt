package com.jadeappstudio.pembukuantk.model

data class GetInvoiceResponseModel(
    var status: String? = "",
    var message: String? = "",
    var data: List<InvoiceResp>
)