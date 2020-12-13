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

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jadeappstudio.pembukuantk.R
import com.jadeappstudio.pembukuantk.adapter.UsersAdapter
import com.jadeappstudio.pembukuantk.viewmodel.UsersManagementViewModel
import kotlinx.android.synthetic.main.activity_users_management.*

class UsersManagementActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users_management)

        btnBack.setOnClickListener {
            val intent = Intent(this, BottomNavActivity::class.java)
            intent.putExtra("redirect", 5)
            startActivity(intent)
        }

        btnAddUser.setOnClickListener {
            startActivity(Intent(this, AddUserActivity::class.java))
        }

        val viewModel = ViewModelProvider(this).get(UsersManagementViewModel::class.java)
        viewModel.getUsers(this).observe(this, {
            if (it.data != null) {
                rvUsers.adapter = UsersAdapter(it.data)
                rvUsers.layoutManager = LinearLayoutManager(this)
            }
        })
    }
}