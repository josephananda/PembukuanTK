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
import android.os.Handler
import android.os.Looper
import android.util.Log
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
                viewModel.checkValid(token, this).observe(this, {
                    if (it.status.equals("error")) {
                        startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                        viewModel.setDataEmpty(this)
                    } else if (it.status.equals("success")) {
                        startActivity(Intent(this@SplashActivity, BottomNavActivity::class.java))
                        Log.i("RESULT", "${it.message}")
                    }
                })
            } else {
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            }
        }, 3000)
    }
}