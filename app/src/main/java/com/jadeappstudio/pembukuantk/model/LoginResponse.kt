package com.jadeappstudio.pembukuantk.model

object LoginResponse {
    data class LoginResp(
        var username: String? = "",
        var user_type_id: Int? = 0,
        var user_id: Int? = 2,
        var token: String? = ""
    )
}