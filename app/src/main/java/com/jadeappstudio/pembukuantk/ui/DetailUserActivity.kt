package com.jadeappstudio.pembukuantk.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jadeappstudio.pembukuantk.R
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
    }
}