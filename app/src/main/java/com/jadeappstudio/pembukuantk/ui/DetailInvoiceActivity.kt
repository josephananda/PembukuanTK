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

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jadeappstudio.pembukuantk.R
import com.jadeappstudio.pembukuantk.adapter.InvoiceDetailAdapter
import com.jadeappstudio.pembukuantk.viewmodel.DetailInvoiceViewModel
import kotlinx.android.synthetic.main.activity_detail_invoice.*

class DetailInvoiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_invoice)

        btnBack.setOnClickListener {
            onBackPressed()
        }

        var invoiceId = intent.getIntExtra("invoiceId", 0)

        tvInvoiceId.text = invoiceId.toString()
        tvCustomerName.text = intent.getStringExtra("customerName")
        tvCustomerPhone.text = intent.getStringExtra("customerPhone")
        tvCustomerAddress.text = intent.getStringExtra("customerAddress")
        tvTimeStamp.text = intent.getStringExtra("timeStamp")
        tvAmount.text = "Rp ${intent.getStringExtra("totalPrice")}"

        var viewModel = ViewModelProvider(this).get(DetailInvoiceViewModel::class.java)

        viewModel.getInvoiceDetail(invoiceId, this).observe(this, {
            if (it.data != null) {
                rvInvoice.adapter = InvoiceDetailAdapter(it.data.products)
                rvInvoice.layoutManager = LinearLayoutManager(this)
            }
        })
    }
}