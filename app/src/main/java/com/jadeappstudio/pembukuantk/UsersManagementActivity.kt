package com.jadeappstudio.pembukuantk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jadeappstudio.pembukuantk.adapter.UsersAdapter
import com.jadeappstudio.pembukuantk.viewmodel.UsersManagementViewModel
import kotlinx.android.synthetic.main.activity_add_user.*
import kotlinx.android.synthetic.main.activity_users_management.*
import kotlinx.android.synthetic.main.activity_users_management.btnBack

class UsersManagementActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users_management)

        btnBack.setOnClickListener {
            onBackPressed()
        }

        btnAddUser.setOnClickListener {
            startActivity(Intent(this, AddUserActivity::class.java))
        }

        var viewModel = ViewModelProvider(this).get(UsersManagementViewModel::class.java)
        viewModel.getUsers(this).observe(this, {
            if(it.data != null) {
                rvUsers.adapter = UsersAdapter(it.data)
                rvUsers.layoutManager = LinearLayoutManager(this)
            }
        })
    }
}