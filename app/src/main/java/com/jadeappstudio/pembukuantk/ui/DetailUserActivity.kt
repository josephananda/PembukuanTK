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