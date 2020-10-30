package com.jadeappstudio.pembukuantk.view

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

            val viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

            viewModel.login(username, password)?.observe(this, {
                if (it == null) {
                    Toast.makeText(this@LoginActivity, "LOGIN GAGAL", Toast.LENGTH_LONG).show()
                } else if (it.data != "") {
                    val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                    intent.putExtra("token", it.data)
                    startActivity(intent)
                    finishAffinity()
                }
            })
        }
    }
}