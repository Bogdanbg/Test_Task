package com.example.testtask

import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.os.Bundle
import android.text.format.Formatter
import androidx.appcompat.app.AppCompatActivity
import com.example.testtask.databinding.ActivityMainBinding
import com.example.testtask.game.GameActivity
import com.example.testtask.webView.WebViewActivity

class MainActivity : AppCompatActivity() {


    // private var targetIp = targetIp.add("10.0.2.16")
    private var targetIp = mutableListOf<String>() // Here you can store a list of ip`s instead of one
                                               // and walk through it to compare with ip of current user
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        targetIp.add("10.2.0.16")
        targetIp.add("11.0.2.12")
      //  targetIp.add("10.0.2.16") //commented real ip to check the condition

        val currentIp:String = getIp(applicationContext)

        if (isValid(currentIp, targetIp))
            startActivity(Intent(this, WebViewActivity::class.java))
        else
            startActivity(Intent(this, GameActivity::class.java))
    }

    private fun isValid(currentIp: String, addressList: MutableList<String>): Boolean{
        var counter = false
        for (address in addressList){
            if (address == currentIp) counter = true
        }
        return counter
    }

    private fun getIp(context: Context): String {
        val wifiManager = context.applicationContext.getSystemService(WIFI_SERVICE) as WifiManager
        return Formatter.formatIpAddress(wifiManager.connectionInfo.ipAddress)

    }
}