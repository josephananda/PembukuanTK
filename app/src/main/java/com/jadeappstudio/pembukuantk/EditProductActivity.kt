package com.jadeappstudio.pembukuantk

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.jadeappstudio.pembukuantk.ui.BottomNavActivity
import kotlinx.android.synthetic.main.activity_edit_product.*

class EditProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_product)

        btnBack.setOnClickListener {
            onBackPressed()
        }

        etProductName.setText(intent.getStringExtra("productName"))
        etProductPrice.setText(intent.getStringExtra("productPrice"))

        btnSave.setOnClickListener {
            val productName = etProductName.text.toString()
            val productPrice = etProductPrice.text.toString()

            btnSave.isClickable = false

            val viewModel = ViewModelProvider(this).get(EditProductViewModel::class.java)
            viewModel.editProduct(
                intent.getIntExtra("productId", 0),
                productName,
                productPrice,
                this
            )?.observe(this, {
                if (it == null) {
                    Toast.makeText(this, "FAILED TO EDIT PRODUCT", Toast.LENGTH_LONG).show()
                    btnSave.isClickable = true
                } else if (it.status.equals("success")) {
                    val intent = Intent(this, BottomNavActivity::class.java)
                    intent.putExtra("redirect", 4)
                    startActivity(intent)
                    finishAffinity()
                }
            })
        }
    }
}