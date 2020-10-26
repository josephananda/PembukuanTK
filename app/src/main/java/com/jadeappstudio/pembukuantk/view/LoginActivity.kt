package com.jadeappstudio.pembukuantk.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jadeappstudio.pembukuantk.R
import com.jadeappstudio.pembukuantk.repo.DataRepository
import com.jadeappstudio.pembukuantk.model.LoginModel
import com.jadeappstudio.pembukuantk.model.ResponseModel
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener{
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            //Post data
            val loginServices = DataRepository.login()
            val user = LoginModel(username, password)
            loginServices.loginUser(user).enqueue(object : Callback<ResponseModel> {
                override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                    if (response.isSuccessful) {
                        val responses = response.body()
                        if(!responses?.status.equals("error")) {
                            val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                            intent.putExtra("token", responses?.data)
                            startActivity(intent)
                            finishAffinity()
                        } else {
                            Toast.makeText(this@LoginActivity, "Login Gagal", Toast.LENGTH_LONG).show()
                        }
                    } else {
                        Toast.makeText(this@LoginActivity, "Login Gagal", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<ResponseModel>, error: Throwable) {
                    Toast.makeText(this@LoginActivity, "Login Gagal", Toast.LENGTH_LONG).show()
                }
            })
        }


    }
}