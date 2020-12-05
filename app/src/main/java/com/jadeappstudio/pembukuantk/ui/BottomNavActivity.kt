package com.jadeappstudio.pembukuantk.ui

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.jadeappstudio.pembukuantk.R

class BottomNavActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        var redirect = intent.getIntExtra("redirect", 0)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_dashboard,
                R.id.navigation_transactions,
                R.id.navigation_customer,
                R.id.navigation_inventory,
                R.id.navigation_profile
            )
        )
        //setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        if(redirect != null){
            when(redirect){
                1-> {
                    val graph = navController.navInflater.inflate(R.navigation.mobile_navigation)
                    graph.startDestination = R.id.navigation_dashboard
                    navController.graph = graph
                }
                2-> {
                    val graph = navController.navInflater.inflate(R.navigation.mobile_navigation)
                    graph.startDestination = R.id.navigation_transactions
                    navController.graph = graph
                }
                3-> {
                    val graph = navController.navInflater.inflate(R.navigation.mobile_navigation)
                    graph.startDestination = R.id.navigation_customer
                    navController.graph = graph
                }
                4-> {
                    val graph = navController.navInflater.inflate(R.navigation.mobile_navigation)
                    graph.startDestination = R.id.navigation_inventory
                    navController.graph = graph
                }
                5-> {
                    val graph = navController.navInflater.inflate(R.navigation.mobile_navigation)
                    graph.startDestination = R.id.navigation_profile
                    navController.graph = graph
                }
            }
        }
    }
}