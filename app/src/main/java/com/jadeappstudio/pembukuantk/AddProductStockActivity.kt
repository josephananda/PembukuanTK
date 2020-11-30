package com.jadeappstudio.pembukuantk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_product.*

class AddProductStockActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product_stock)

        btnBack.setOnClickListener {
            onBackPressed()
        }
    }
}