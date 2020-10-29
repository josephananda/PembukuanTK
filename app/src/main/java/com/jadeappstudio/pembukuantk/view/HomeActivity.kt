package com.jadeappstudio.pembukuantk.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jadeappstudio.pembukuantk.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //token.text = intent.getStringExtra("token")

        Toast.makeText(this@HomeActivity, "${intent.getStringExtra("token")}", Toast.LENGTH_LONG).show()

        // get post data
        /*val postServices = DataRepository.create()
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
        })*/


    }
}