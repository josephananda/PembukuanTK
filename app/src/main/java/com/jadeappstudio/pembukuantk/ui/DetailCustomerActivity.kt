/*
 * Created by Joseph Ananda Sugihdharma on 12/11/20 11:41 PM .
 * Copyright (c) 2020 . All rights reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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