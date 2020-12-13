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
import com.jadeappstudio.pembukuantk.model.UsersModel
import com.jadeappstudio.pembukuantk.ui.DetailUserActivity

class UsersAdapter(private val users: List<UsersModel>) :
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

            holder.itemView.setOnClickListener {
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