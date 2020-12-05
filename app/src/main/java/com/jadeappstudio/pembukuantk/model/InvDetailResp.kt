package com.jadeappstudio.pembukuantk.model

object InvDetailResp {
    data class InvoiceDetail(
        var id: Int? = 0,
        var customer_name: String? = "",
        var customer_phone: String? = "",
        var customer_email: String? = "",
        var customer_address: String? = "",
        var total_invoice_price: String? = "",
        var created_at: String? = "",
        var updated_at: String? = "",
        var products: List<ItemInvoice>
    )
}