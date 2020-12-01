package com.jadeappstudio.pembukuantk.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jadeappstudio.pembukuantk.R
import com.jadeappstudio.pembukuantk.model.ContactItemListResponse

class ContactsAdapter(val contactItem: List<ContactItemListResponse>): RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder>() {

    inner class ContactsViewHolder(items: View): RecyclerView.ViewHolder(items)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return contactItem.size
    }
}