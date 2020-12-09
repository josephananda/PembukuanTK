package com.jadeappstudio.pembukuantk.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jadeappstudio.pembukuantk.ui.DetailUserActivity
import com.jadeappstudio.pembukuantk.R
import com.jadeappstudio.pembukuantk.model.UsersModel

class UsersAdapter(val users: List<UsersModel>) :
    RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {

    inner class UsersViewHolder(items: View) : RecyclerView.ViewHolder(items)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val layoutInflater =
            LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UsersViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.itemView.apply {
            val tvUsername = findViewById<TextView>(R.id.tvUsername)

            tvUsername.text = users[position].username

            holder.itemView.setOnClickListener{
                val intent = Intent(context, DetailUserActivity::class.java)
                intent.putExtra("userId", users[position].id)
                intent.putExtra("username", users[position].username)
                intent.putExtra("userTypeId", users[position].user_type_id)
                intent.putExtra("userPassword", users[position].password)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }
}