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
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jadeappstudio.pembukuantk.R
import com.jadeappstudio.pembukuantk.adapter.CustomerAdapter
import com.jadeappstudio.pembukuantk.viewmodel.CustomerViewModel
import kotlinx.android.synthetic.main.fragment_customer.*

class CustomerFragment : Fragment() {

    private lateinit var customerViewModel: CustomerViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        customerViewModel =
            ViewModelProvider(this).get(CustomerViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_customer, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnAddCustomer.setOnClickListener {
            startActivity(
                Intent(activity, AddCustomerActivity::class.java)
            )
        }
        customerViewModel.getCustomer(requireContext()).observe(viewLifecycleOwner, {
            if (it.data != null) {
                rvCustomer.adapter = CustomerAdapter(it.data)
                rvCustomer.layoutManager = LinearLayoutManager(requireContext())
            }
        })
    }
}