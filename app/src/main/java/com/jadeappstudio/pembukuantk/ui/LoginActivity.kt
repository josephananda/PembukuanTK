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
import com.jadeappstudio.pembukuantk.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            btnLogin.isEnabled = false
            btnLogin.isClickable = false

            val viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
            val valid = viewModel.isFormValid(username, password)
            if (valid == "") {
                viewModel.login(username, password, this)?.observe(this, {
                    if (it == null) {
                        Toast.makeText(this@LoginActivity, "LOGIN GAGAL", Toast.LENGTH_LONG).show()
                        btnLogin.isEnabled = true
                        btnLogin.isClickable = true
                    } else if (it.data.token != "") {
                        viewModel.saveToken(it.data.token.toString(), this)
                        viewModel.saveData(
                            it.data.user_id!!,
                            it.data.user_type_id!!,
                            it.data.username.toString(),
                            this
                        )
                        val intent = Intent(this@LoginActivity, BottomNavActivity::class.java)
                        intent.putExtra("token", it.data.token)
                        startActivity(intent)
                        finishAffinity()
                    }
                })
            } else {
                Toast.makeText(this@LoginActivity, valid, Toast.LENGTH_LONG).show()
                btnLogin.isEnabled = true
                btnLogin.isClickable = true
            }
        }
    }
}