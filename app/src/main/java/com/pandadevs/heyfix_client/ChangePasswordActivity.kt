package com.pandadevs.heyfix_client

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pandadevs.heyfix_client.databinding.ActivityChangePasswordBinding

class ChangePasswordActivity : AppCompatActivity() {
    lateinit var binding:ActivityChangePasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tbApp.setNavigationOnClickListener { finish() }
    }
}