package com.jadeappstudio.pembukuantk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jadeappstudio.pembukuantk.model.DataRepository
import com.jadeappstudio.pembukuantk.model.PostModel
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // get post data
        val postServices = DataRepository.create()
        postServices.getPosts().enqueue(object : retrofit2.Callback<List<PostModel>> {

            override fun onResponse(call: Call<List<PostModel>>, response: Response<List<PostModel>>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    Log.d("tag", "responsennya ${data?.size}")

                    data?.map {
                        Log.d("tag", "datanya ${it.body}")
                    }
                }
            }

            override fun onFailure(call: Call<List<PostModel>>, error: Throwable) {
                Log.e("tag", "errornya ${error.message}")
            }
        })
    }
}