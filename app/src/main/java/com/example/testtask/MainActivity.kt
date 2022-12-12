package com.example.testtask

import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.testtask.databinding.ActivityMainBinding
import com.example.testtask.game.GameActivity
import com.example.testtask.webView.WebViewActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.guestButton.setOnClickListener {
            startActivity(Intent(this, GameActivity::class.java))
        }

        binding.moderatorBotButton.setOnClickListener {
            startActivity(Intent(this, WebViewActivity::class.java))
        }
    }
}