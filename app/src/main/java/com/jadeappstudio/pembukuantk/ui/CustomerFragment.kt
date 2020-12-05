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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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