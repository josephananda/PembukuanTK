package com.jadeappstudio.pembukuantk.model

import retrofit2.Call
import retrofit2.http.GET

interface PostServices {
    @GET("posts")
    fun getPosts(): Call<List<PostModel>>
}