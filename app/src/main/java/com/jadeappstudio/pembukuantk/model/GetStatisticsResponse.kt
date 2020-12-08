package com.jadeappstudio.pembukuantk.model

data class GetStatisticsResponse(
    var status: String? = "",
    var message: String? = "",
    var data: StatisticsResponse.StatisticsResp
)