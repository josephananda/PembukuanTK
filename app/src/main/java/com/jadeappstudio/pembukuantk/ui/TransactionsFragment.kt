package com.jadeappstudio.pembukuantk.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jadeappstudio.pembukuantk.AddInvoiceActivity
import com.jadeappstudio.pembukuantk.R
import com.jadeappstudio.pembukuantk.viewmodel.TransactionsViewModel
import kotlinx.android.synthetic.main.fragment_transactions.*

class TransactionsFragment : Fragment() {

    private lateinit var transactionsViewModel: TransactionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        transactionsViewModel =
            ViewModelProvider(this).get(TransactionsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_transactions, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnAddInvoice.setOnClickListener {
            startActivity(Intent(requireContext(), AddInvoiceActivity::class.java))
        }
    }
}