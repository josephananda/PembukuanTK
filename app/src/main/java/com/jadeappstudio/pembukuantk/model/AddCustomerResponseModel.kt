package com.jadeappstudio.pembukuantk.model

data class AddCustomerResponseModel(
    var status: String? = "",
    var message: String? = "",
    var data: CustomerResponseModel.CustomerResponse
)
