package com.example.c0768448_w2020_mad3125_fp.UI

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.c0768448_w2020_mad3125_fp.R

class SplashScreenActivity : AppCompatActivity() {
    var handler: Handler? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        handler = Handler()
        handler!!.postDelayed({
            val intent = Intent(this@SplashScreenActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000)
    }
}