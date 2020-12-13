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
import com.jadeappstudio.pembukuantk.viewmodel.EditCustomerViewModel
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
            viewModel.editCustomer(
                intent.getIntExtra("customerId", 0),
                customerName,
                customerPhone,
                customerEmail,
                customerAddress,
                this
            )?.observe(this, {
                if (it == null) {
                    Toast.makeText(this, "FAILED TO EDIT CUSTOMER", Toast.LENGTH_LONG).show()
                    btnSave.isClickable = true
                } else if (it.status.equals("success")) {
                    val intent = Intent(this, BottomNavActivity::class.java)
                    intent.putExtra("redirect", 3)
                    startActivity(intent)
                    finishAffinity()
                }
            })
        }
    }
}