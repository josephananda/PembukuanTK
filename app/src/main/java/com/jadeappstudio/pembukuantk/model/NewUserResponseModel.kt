package com.jadeappstudio.pembukuantk.model

object NewUserResponseModel {
    data class NewUserResp(
        var id: Int? = 0,
        var username: String? = "",
        var password: String? = "",
        var user_type_id: Int? = 0
    )
}