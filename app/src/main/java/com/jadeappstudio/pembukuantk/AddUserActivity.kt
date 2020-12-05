package com.jadeappstudio.pembukuantk

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.jadeappstudio.pembukuantk.ui.BottomNavActivity
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