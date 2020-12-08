package com.jadeappstudio.pembukuantk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.jadeappstudio.pembukuantk.ui.BottomNavActivity
import com.jadeappstudio.pembukuantk.viewmodel.AddCustomerViewModel
import kotlinx.android.synthetic.main.activity_edit_customer.*

class EditCustomerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_customer)

        btnBack.setOnClickListener {
            onBackPressed()
        }

        etCustomerName.setText(intent.getStringExtra("customerName"))
        etCustomerPhone.setText(intent.getStringExtra("customerPhone"))
        etCustomerEmail.setText(intent.getStringExtra("customerEmail"))
        etCustomerAddress.setText(intent.getStringExtra("customerAddress"))

        btnSave.setOnClickListener {
            val customerName = etCustomerName.text.toString()
            val customerPhone = etCustomerPhone.text.toString()
            val customerEmail = etCustomerEmail.text.toString()
            val customerAddress = etCustomerAddress.text.toString()

            btnSave.isClickable = false

            val viewModel = ViewModelProvider(this).get(EditCustomerViewModel::class.java)
            viewModel.editCustomer(intent.getIntExtra("customerId", 0), customerName, customerPhone, customerEmail, customerAddress, this)?.observe(this, {
                if(it == null){
                    Toast.makeText(this, "FAILED TO EDIT CUSTOMER", Toast.LENGTH_LONG).show()
                    btnSave.isClickable = true
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