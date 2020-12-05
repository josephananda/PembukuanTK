package com.jadeappstudio.pembukuantk.model

data class UsersModel(
    var id: Int? = 0,
    var username: String? = "",
    var password: String? = "",
    var user_type_id: Int? = 0
)