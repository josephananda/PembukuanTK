package com.jadeappstudio.pembukuantk.model

data class GetUsersResponseModel(
    var status: String? = "",
    var message: String? = "",
    var data: List<UsersModel>
)