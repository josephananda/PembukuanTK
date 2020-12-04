package com.jadeappstudio.pembukuantk.model

data class AddInvoiceModel(
    var customer_id: Int? = 0,
    var user_id: Int? = 0,
    var list_product: MutableList<ItemListInvoice>
)