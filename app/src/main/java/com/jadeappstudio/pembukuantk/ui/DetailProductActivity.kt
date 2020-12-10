package com.jadeappstudio.pembukuantk.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.jadeappstudio.pembukuantk.R
import com.jadeappstudio.pembukuantk.viewmodel.DetailProductViewModel
import kotlinx.android.synthetic.main.activity_add_product.btnBack
import kotlinx.android.synthetic.main.activity_add_product.tvProductName
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

        btnDeleteProduct.setOnClickListener {
            btnDeleteProduct.isClickable = false

            val viewModel = ViewModelProvider(this).get(DetailProductViewModel::class.java)
            viewModel.deleteProduct(productId, this)?.observe(this, {
                if (it == null) {
                    Toast.makeText(this, "FAILED TO DELETE PRODUCT", Toast.LENGTH_LONG).show()
                    btnDeleteProduct.isClickable = true
                } else if (it.status.equals("success")) {
                    Toast.makeText(this, "${it.message}", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, BottomNavActivity::class.java)
                    intent.putExtra("redirect", 4)
                    startActivity(intent)
                    finishAffinity()
                }
            })
        }
    }
}