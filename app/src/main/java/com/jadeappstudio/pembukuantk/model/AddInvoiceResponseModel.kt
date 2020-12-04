package com.jadeappstudio.pembukuantk.model

data class AddInvoiceResponseModel(
    var status: String? = "",
    var message: String? = "",
    var data: InvoiceResponse.InvoiceResp
)