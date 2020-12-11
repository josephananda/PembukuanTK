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
import com.jadeappstudio.pembukuantk.adapter.ProductAdapter
import com.jadeappstudio.pembukuantk.viewmodel.InventoryViewModel
import kotlinx.android.synthetic.main.fragment_inventory.*

class InventoryFragment : Fragment() {

    private lateinit var inventoryViewModel: InventoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inventoryViewModel =
            ViewModelProvider(this).get(InventoryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_inventory, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAddProduct.setOnClickListener {
            startActivity(Intent(activity, AddProductActivity::class.java))
        }
        inventoryViewModel.getProduct(requireContext()).observe(viewLifecycleOwner, {
            if (it.data != null) {
                rvInventory.adapter = ProductAdapter(it.data)
                rvInventory.layoutManager = LinearLayoutManager(requireContext())
            }
        })
    }
}