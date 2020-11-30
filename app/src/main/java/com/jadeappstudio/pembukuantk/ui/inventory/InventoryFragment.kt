package com.jadeappstudio.pembukuantk.ui.inventory

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jadeappstudio.pembukuantk.AddProductActivity
import com.jadeappstudio.pembukuantk.AddProductStockActivity
import com.jadeappstudio.pembukuantk.R
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
        /*val textView: TextView = root.findViewById(R.id.text_dashboard)
        inventoryViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAddProduct.setOnClickListener {
            startActivity(Intent(activity, AddProductActivity::class.java))
        }
    }
}