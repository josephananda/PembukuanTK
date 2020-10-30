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

        Toast.makeText(this@HomeActivity, "${intent.getStringExtra("token")}", Toast.LENGTH_LONG).show()
    }
}