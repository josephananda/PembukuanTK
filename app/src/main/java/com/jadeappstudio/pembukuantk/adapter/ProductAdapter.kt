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
            tvSisaStock.text = "Sisa stock: ${productItem[position]?.stock?: 0}"

            holder.itemView.setOnClickListener{
                val intent = Intent(context, AddProductStockActivity::class.java)
                intent.putExtra("productId", productItem[position].id)
                intent.putExtra("productName", productItem[position].name)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return productItem.size
    }
}