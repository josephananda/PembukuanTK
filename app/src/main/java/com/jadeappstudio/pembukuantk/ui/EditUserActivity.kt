package com.jadeappstudio.pembukuantk.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.jadeappstudio.pembukuantk.R
import com.jadeappstudio.pembukuantk.viewmodel.EditUserViewModel
import kotlinx.android.synthetic.main.activity_edit_user.*
import kotlinx.android.synthetic.main.activity_edit_user.btnBack
import kotlinx.android.synthetic.main.activity_edit_user.btnSave

class EditUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_user)

        btnBack.setOnClickListener {
            onBackPressed()
        }

        etUsername.setText(intent.getStringExtra("username"))

        btnSave.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            btnSave.isClickable = false

            val viewModel = ViewModelProvider(this).get(EditUserViewModel::class.java)
            viewModel.editUser(intent.getIntExtra("userId", 0), username, password, this)?.observe(this, {
                if(it == null){
                    Toast.makeText(this, "FAILED TO EDIT USER", Toast.LENGTH_LONG).show()
                    btnSave.isClickable = true
                } else if(it.status.equals("success")){
                    startActivity(Intent(this, UsersManagementActivity::class.java))
                    finishAffinity()
                }
            })
        }
    }
}