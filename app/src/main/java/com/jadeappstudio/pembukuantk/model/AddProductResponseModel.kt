package com.jadeappstudio.pembukuantk.model

import java.util.*

data class AddProductResponseModel(
    var status: String? = "",
    var message: String? = "",
    var data: ProductResponseModel
)