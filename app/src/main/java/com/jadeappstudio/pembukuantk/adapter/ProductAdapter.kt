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

package com.jadeappstudio.pembukuantk.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jadeappstudio.pembukuantk.R
import com.jadeappstudio.pembukuantk.model.ProductItemListResponse
import com.jadeappstudio.pembukuantk.ui.AddProductStockActivity
import com.jadeappstudio.pembukuantk.ui.DetailProductActivity

class ProductAdapter(val productItem: List<ProductItemListResponse>): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(items: View): RecyclerView.ViewHolder(items)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.itemView.apply{
            val tvProductName = findViewById<TextView>(R.id.tvProductName)
            val tvProductPrice = findViewById<TextView>(R.id.tvProductPrice)
            val tvSisaStock = findViewById<TextView>(R.id.tvSisaStock)

            tvProductName.text = productItem[position].name ?:""
            tvProductPrice.text = "Rp ${productItem[position]?.price?:""}"
            tvSisaStock.text = "Remaining Stock: ${productItem[position]?.stock?: 0}"

            holder.itemView.setOnClickListener{
                val intent = Intent(context, DetailProductActivity::class.java)
                intent.putExtra("productId", productItem[position].id)
                intent.putExtra("productName", productItem[position].name)
                intent.putExtra("productStock", productItem[position].stock)
                intent.putExtra("productPrice", productItem[position].price)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return productItem.size
    }
}