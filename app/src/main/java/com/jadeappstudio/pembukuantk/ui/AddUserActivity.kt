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
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.jadeappstudio.pembukuantk.R
import com.jadeappstudio.pembukuantk.viewmodel.AddUserViewModel
import kotlinx.android.synthetic.main.activity_add_customer.*
import kotlinx.android.synthetic.main.activity_add_user.*
import kotlinx.android.synthetic.main.activity_add_user.btnBack

class AddUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)

        btnBack.setOnClickListener {
            onBackPressed()
        }

        var viewModel = ViewModelProvider(this).get(AddUserViewModel::class.java)
        btnAddNewUser.setOnClickListener {
            var username = etUsername.text.toString()
            var password = etPassword.text.toString()

            btnAddNewUser.isClickable = false

            viewModel.addUser(username, password, this).observe(this, {
                if (it == null) {
                    Toast.makeText(this, "FAILED TO ADD USER", Toast.LENGTH_LONG).show()
                    btnAddCustomer.isClickable = true
                } else if (it.status.equals("success")) {
                    startActivity(Intent(this, UsersManagementActivity::class.java))
                    finishAffinity()
                }
            })
        }
    }
}