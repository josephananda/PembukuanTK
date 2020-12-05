package com.jadeappstudio.pembukuantk

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jadeappstudio.pembukuantk.adapter.ChooseCustomerAdapter
import com.jadeappstudio.pembukuantk.viewmodel.CustomerViewModel
import kotlinx.android.synthetic.main.fragment_customer.*

class ChooseCustomerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_customer)

        var customerViewModel = ViewModelProvider(this).get(CustomerViewModel::class.java)

        customerViewModel.getCustomer(this).observe(this, {
            if (it.data != null) {
                rvCustomer.adapter = ChooseCustomerAdapter(it.data)
                rvCustomer.layoutManager = LinearLayoutManager(this)
            }
        })
    }
}