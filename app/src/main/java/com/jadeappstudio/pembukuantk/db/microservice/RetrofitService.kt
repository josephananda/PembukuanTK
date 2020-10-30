package com.jadeappstudio.pembukuantk.db.microservice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    fun create(): ApiService {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://pembukuantk.herokuapp.com/")
            .build()

        return retrofit.create(ApiService::class.java)
    }
}

