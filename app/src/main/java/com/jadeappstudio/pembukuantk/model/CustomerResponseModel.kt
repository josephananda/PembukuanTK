package com.jadeappstudio.pembukuantk.model

object CustomerResponseModel {
    data class CustomerResponse(
        var id: Int? = 0,
        var name: String? = "",
        var phone: String? = "",
        var email: String? = "",
        var address: String? = ""
    )
}