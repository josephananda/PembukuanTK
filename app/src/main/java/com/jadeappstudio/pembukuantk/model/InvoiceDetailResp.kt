package com.jadeappstudio.pembukuantk.model

data class InvoiceDetailResp(
    var status: String? = "",
    var message: String? = "",
    var data: InvDetailResp.InvoiceDetail
)