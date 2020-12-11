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
import com.jadeappstudio.pembukuantk.viewmodel.DetailUserViewModel
import kotlinx.android.synthetic.main.activity_detail_user.*

class DetailUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        btnBack.setOnClickListener {
            onBackPressed()
        }

        val userId = intent.getIntExtra("userId", 0)
        val username = intent.getStringExtra("username")
        val userPass = intent.getStringExtra("userPassword")
        val userTypeId = intent.getStringExtra("userTypeId")

        tvUsername.text = username

        btnEditUser.setOnClickListener {
            intent = Intent(this, EditUserActivity::class.java)
            intent.putExtra("userId", userId)
            intent.putExtra("username", username)
            intent.putExtra("userTypeId", userTypeId)
            intent.putExtra("userPassword", userPass)
            startActivity(intent)
        }

        btnDeleteUser.setOnClickListener {
            btnDeleteUser.isClickable = false

            val viewModel = ViewModelProvider(this).get(DetailUserViewModel::class.java)
            viewModel.deleteUser(userId, this)?.observe(this, {
                if (it == null) {
                    Toast.makeText(this, "FAILED TO DELETE USER", Toast.LENGTH_LONG).show()
                    btnDeleteUser.isClickable = true
                } else if (it.status.equals("success")) {
                    Toast.makeText(this, "${it.message}", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this, UsersManagementActivity::class.java))
                    finishAffinity()
                }
            })
        }
    }
}