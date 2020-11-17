package com.jadeappstudio.pembukuantk.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.jadeappstudio.pembukuantk.R
import com.jadeappstudio.pembukuantk.utils.SessionManager
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
                    } else if (it.data != "") {
                        viewModel.saveToken(it.data.toString(), this)
                        val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                        intent.putExtra("token", it.data)
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