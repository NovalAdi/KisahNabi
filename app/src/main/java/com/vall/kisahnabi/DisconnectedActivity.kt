package com.vall.kisahnabi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vall.kisahnabi.databinding.ActivityDisconnectedBinding

class DisconnectedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDisconnectedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisconnectedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIntenttomain.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}