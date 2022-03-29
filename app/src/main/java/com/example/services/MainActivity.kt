package com.example.services

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.services.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var br:BroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        br= MyBroadcastReceiver()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).apply {
            registerReceiver(br, this)
        }


        binding.startService.setOnClickListener {
            startService()
        }
        binding.endService.setOnClickListener {
            stopService()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(br)
    }

    private fun startService() {
        val intent=Intent(this,MainService::class.java)
        applicationContext.startForegroundService(intent)
    }
    private fun stopService() {
        stopService(Intent(baseContext, MainService::class.java))
    }
}