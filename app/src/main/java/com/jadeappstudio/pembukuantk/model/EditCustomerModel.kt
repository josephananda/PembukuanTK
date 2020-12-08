package com.jadeappstudio.pembukuantk.model

data class EditCustomerModel (
    var id: Int? = 0,
    var name: String? = "",
    var phone: String? = "",
    var email: String? = "",
    var address: String? = ""
)