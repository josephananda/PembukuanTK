package com.jadeappstudio.pembukuantk.model

object InvoiceResponse {
    data class InvoiceResp(
        var id: Int? = 0,
        var customer_id: Int? = 0,
        var user_id: Int? = 0
    )
}