package com.example.services

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.services.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.startService.setOnClickListener {
            startService()
        }
        binding.endService.setOnClickListener {
            stopService()
        }
    }
    private fun startService() {
        startService(Intent(this, MainService::class.java))
    }
    private fun stopService() {
        stopService(Intent(baseContext, MainService::class.java))
    }
}