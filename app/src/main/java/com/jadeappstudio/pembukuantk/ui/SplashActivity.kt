package com.jadeappstudio.pembukuantk.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.jadeappstudio.pembukuantk.R
import com.jadeappstudio.pembukuantk.viewmodel.SplashViewModel
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        val animFadeIn = AnimationUtils.loadAnimation(
            this,
            R.anim.anim_fade_in
        )

        ivApplogo.startAnimation(animFadeIn)

        val viewModel = ViewModelProvider(this).get(SplashViewModel::class.java)
        val token = viewModel.checkToken(this)
        Handler(Looper.getMainLooper()).postDelayed({
            if (token != "") {
                startActivity(Intent(this@SplashActivity, BottomNavActivity::class.java))
            } else {
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            }
        }, 3000)
    }
}