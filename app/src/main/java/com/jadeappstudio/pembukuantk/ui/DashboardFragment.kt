package com.jadeappstudio.pembukuantk.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.jadeappstudio.pembukuantk.R
import com.jadeappstudio.pembukuantk.viewmodel.DashboardViewModel
import kotlinx.android.synthetic.main.fragment_dashboard.*
import java.util.*
import kotlin.collections.ArrayList

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        dashboardViewModel.getStatistics(requireContext()).observe(viewLifecycleOwner, {
            if (it.data != null) {
                val entries = ArrayList<BarEntry>()
                //Log.i("MONTH", "$data")
                for (i in 0..it.data.detail.size - 1) {
                    entries.add(BarEntry(it.data.detail[i].profit!!.toFloat(), i))
                }
                val barDataSet = BarDataSet(entries, Calendar.getInstance().get(Calendar.YEAR).toString())

                val labels = arrayListOf(
                    "Jan",
                    "Feb",
                    "Mar",
                    "Apr",
                    "May",
                    "Jun",
                    "Jul",
                    "Aug",
                    "Sep",
                    "Oct",
                    "Nov",
                    "Dec"
                )
                val data = BarData(labels, barDataSet)
                barChart.data = data

                barChart.setDescription("Annual Profit")

                barDataSet.setColors(ColorTemplate.COLORFUL_COLORS)
                barDataSet.color = resources.getColor(R.color.bluePrimary)

                barChart.animateY(2000)
            }
        })
    }
}