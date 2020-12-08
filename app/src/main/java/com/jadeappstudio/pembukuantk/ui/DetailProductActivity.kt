package com.jadeappstudio.pembukuantk.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jadeappstudio.pembukuantk.EditProductActivity
import com.jadeappstudio.pembukuantk.R
import kotlinx.android.synthetic.main.activity_add_product.*
import kotlinx.android.synthetic.main.activity_add_product.btnBack
import kotlinx.android.synthetic.main.activity_add_product.tvProductName
import kotlinx.android.synthetic.main.activity_add_product_stock.*
import kotlinx.android.synthetic.main.activity_add_product_stock.btnAddProductStock
import kotlinx.android.synthetic.main.activity_detail_product.*

class DetailProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_product)

        btnBack.setOnClickListener {
            onBackPressed()
        }

        val productId = intent.getIntExtra("productId", 0)
        val productName = intent.getStringExtra("productName")
        val productStock = intent.getIntExtra("productStock", 0)
        val productPrice = intent.getStringExtra("productPrice")

        tvProductName.text = productName
        tvSisaStockAmnt.text = productStock.toString()
        tvProductPriceAmnt.text = "Rp $productPrice"

        btnAddProductStock.setOnClickListener {
            intent = Intent(this, AddProductStockActivity::class.java)
            intent.putExtra("productId", productId)
            intent.putExtra("productName", productName)
            intent.putExtra("productStock", productStock)
            startActivity(intent)
        }

        btnEditProduct.setOnClickListener {
            intent = Intent(this, EditProductActivity::class.java)
            intent.putExtra("productId", productId)
            intent.putExtra("productName", productName)
            intent.putExtra("productPrice", productPrice)
            startActivity(intent)
        }
    }
}