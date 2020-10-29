package com.jadeappstudio.pembukuantk.repo

import com.jadeappstudio.pembukuantk.db.microservice.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataRepository {
    /*fun create(): PostServices {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()
        return retrofit.create(PostServices::class.java)
    }*/

    fun login(): ApiService {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://pembukuantk.herokuapp.com/")
            .build()
        return retrofit.create(ApiService::class.java)
    }
}