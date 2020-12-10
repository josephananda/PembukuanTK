package com.jadeappstudio.pembukuantk.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.jadeappstudio.pembukuantk.R
import com.jadeappstudio.pembukuantk.viewmodel.DetailCustomerViewModel
import kotlinx.android.synthetic.main.activity_detail_customer.*

class DetailCustomerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_customer)

        btnBack.setOnClickListener {
            onBackPressed()
        }

        val customerId = intent.getIntExtra("customerId", 0)
        val customerName = intent.getStringExtra("customerName")
        val customerPhone = intent.getStringExtra("customerPhone")
        val customerEmail = intent.getStringExtra("customerEmail")
        val customerAddress = intent.getStringExtra("customerAddress")

        tvCustomerName.text = customerName
        tvCustomerPhone.text = customerPhone
        tvCustomerEmail.text = customerEmail
        tvCustomerAddress.text = customerAddress

        btnEditCustomer.setOnClickListener {
            intent = Intent(this, EditCustomerActivity::class.java)
            intent.putExtra("customerId", customerId)
            intent.putExtra("customerName", customerName)
            intent.putExtra("customerPhone", customerPhone)
            intent.putExtra("customerEmail", customerEmail)
            intent.putExtra("customerAddress", customerAddress)
            startActivity(intent)
        }

        btnDeleteCustomer.setOnClickListener {
            btnDeleteCustomer.isClickable = false

            val viewModel = ViewModelProvider(this).get(DetailCustomerViewModel::class.java)
            viewModel.deleteCustomer(customerId, this)?.observe(this, {
                if (it == null) {
                    Toast.makeText(this, "FAILED TO DELETE CUSTOMER", Toast.LENGTH_LONG).show()
                    btnDeleteCustomer.isClickable = true
                } else if (it.status.equals("success")) {
                    Toast.makeText(this, "${it.message}", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, BottomNavActivity::class.java)
                    intent.putExtra("redirect", 3)
                    startActivity(intent)
                    finishAffinity()
                }
            })
        }
    }
}