package com.jadeappstudio.pembukuantk.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jadeappstudio.pembukuantk.R
import com.jadeappstudio.pembukuantk.viewmodel.ContactsViewModel

class ContactsFragment : Fragment() {

    private lateinit var contactsViewModel: ContactsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        contactsViewModel =
            ViewModelProvider(this).get(ContactsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_contacts, container, false)
        /*val textView: TextView = root.findViewById(R.id.text_notifications)
        contactsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/
        return root
    }
}