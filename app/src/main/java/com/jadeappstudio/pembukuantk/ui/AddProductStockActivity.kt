package com.jadeappstudio.pembukuantk.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.jadeappstudio.pembukuantk.R
import com.jadeappstudio.pembukuantk.viewmodel.AddProductStockViewModel
import kotlinx.android.synthetic.main.activity_add_product.btnBack
import kotlinx.android.synthetic.main.activity_add_product_stock.*

class AddProductStockActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product_stock)

        btnBack.setOnClickListener {
            onBackPressed()
        }

        tvProductName.text = intent.getStringExtra("productName")

        btnAddProductStock.setOnClickListener {
            val productQuantity = etQuantity.text.toString().toInt()
            val viewModel = ViewModelProvider(this).get(AddProductStockViewModel::class.java)
            viewModel.addStock(intent.getIntExtra("productId", 0), productQuantity, this).observe(this, {
                if (it == null) {
                    Toast.makeText(this, "FAILED TO ADD QUANTITY", Toast.LENGTH_LONG).show()
                    btnAddProductStock.isClickable = false
                } else if (it.status.equals("success")) {
                    val intent = Intent(this, BottomNavActivity::class.java)
                    startActivity(intent)
                    finishAffinity()
                }
            })
        }
    }
}