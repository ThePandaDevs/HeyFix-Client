package com.pandadevs.heyfix_client.view

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.core.app.ActivityCompat
import com.pandadevs.heyfix_client.databinding.ActivitySplashBinding
import com.pandadevs.heyfix_client.utils.SharedPreferenceManager
import com.pandadevs.heyfix_client.utils.SnackbarShow

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Handler().postDelayed({
            val active = SharedPreferenceManager(this).getSession()
            if (active) startActivity(Intent(this, MainActivity::class.java))
            else startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, 2000)
    }


}