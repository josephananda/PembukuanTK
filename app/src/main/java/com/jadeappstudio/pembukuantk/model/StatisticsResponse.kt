package com.jadeappstudio.pembukuantk.model

object StatisticsResponse {
    data class StatisticsResp(
        var year: String? = "",
        var detail: List<StatisticsDetail>
    )
}