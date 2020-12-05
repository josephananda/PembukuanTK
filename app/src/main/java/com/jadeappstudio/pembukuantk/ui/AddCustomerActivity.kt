package com.jadeappstudio.pembukuantk.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.jadeappstudio.pembukuantk.R
import com.jadeappstudio.pembukuantk.viewmodel.AddCustomerViewModel
import kotlinx.android.synthetic.main.activity_add_customer.*

class AddCustomerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_customer)

        btnBack.setOnClickListener {
            onBackPressed()
        }

        btnAddCustomer.setOnClickListener {
            val customerName = etCustomerName.text.toString()
            val customerPhone = etCustomerPhone.text.toString()
            val customerEmail = etCustomerEmail.text.toString()
            val customerAddress = etCustomerAddress.text.toString()

            btnAddCustomer.isClickable = false

            val viewModel = ViewModelProvider(this).get(AddCustomerViewModel::class.java)
            viewModel.addCustomer(customerName, customerPhone, customerEmail, customerAddress, this)?.observe(this, {
                if(it == null){
                    Toast.makeText(this, "FAILED TO ADD CUSTOMER", Toast.LENGTH_LONG).show()
                    btnAddCustomer.isClickable = true
                } else if(it.status.equals("success")){
                    val intent = Intent(this, BottomNavActivity::class.java)
                    intent.putExtra("redirect", 3)
                    startActivity(intent)
                    finishAffinity()
                }
            })
        }
    }
}