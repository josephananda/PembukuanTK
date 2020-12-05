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