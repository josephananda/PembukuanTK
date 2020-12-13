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

package com.jadeappstudio.pembukuantk.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
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

        if (redirect != null) {
            when (redirect) {
                1 -> {
                    val graph = navController.navInflater.inflate(R.navigation.mobile_navigation)
                    graph.startDestination = R.id.navigation_dashboard
                    navController.graph = graph
                }
                2 -> {
                    val graph = navController.navInflater.inflate(R.navigation.mobile_navigation)
                    graph.startDestination = R.id.navigation_transactions
                    navController.graph = graph
                }
                3 -> {
                    val graph = navController.navInflater.inflate(R.navigation.mobile_navigation)
                    graph.startDestination = R.id.navigation_customer
                    navController.graph = graph
                }
                4 -> {
                    val graph = navController.navInflater.inflate(R.navigation.mobile_navigation)
                    graph.startDestination = R.id.navigation_inventory
                    navController.graph = graph
                }
                5 -> {
                    val graph = navController.navInflater.inflate(R.navigation.mobile_navigation)
                    graph.startDestination = R.id.navigation_profile
                    navController.graph = graph
                }
            }
        }
    }
}