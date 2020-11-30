package com.jadeappstudio.pembukuantk

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_add_product.*
import kotlinx.android.synthetic.main.activity_login.*

class AddProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)

        btnBack.setOnClickListener {
            onBackPressed()
        }

        btnAddProduct.setOnClickListener {
            val productName = etProductName.text.toString()
            val productPrice = etProductPrice.text.toString()

            btnAddProduct.isEnabled = false
            btnAddProduct.isClickable = false

            val viewModel = ViewModelProvider(this).get(AddProductViewModel::class.java)
            viewModel.addProduct(productName, productPrice, this)?.observe(this, {
                if (it == null) {
                    Toast.makeText(this, "FAILED TO ADD PRODUCT", Toast.LENGTH_LONG).show()
                    btnAddProduct.isEnabled = true
                    btnAddProduct.isClickable = true
                } else if (it.status.equals("success")) {
                    val intent = Intent(this, BottomNavActivity::class.java)
                    startActivity(intent)
                    finishAffinity()
                }
            })
        }
    }
}