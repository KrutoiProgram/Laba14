package com.example.laba14api

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import android.util.Log
import android.widget.Button
import android.widget.TextView
import org.json.JSONObject
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.net.ssl.HttpsURLConnection

private lateinit var btnGeek: Button
private lateinit var btnPunchline: Button
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnGeek = findViewById(R.id.btn_geek)
        btnPunchline = findViewById(R.id.btn_punchline)
        btnGeek.setOnClickListener{
            val intent = Intent(this, GeekJokesActivity::class.java)
            startActivity(intent)
        }
        btnPunchline.setOnClickListener {
            val intent = Intent(this, SetupPunchlineActivity::class.java)
            startActivity(intent)
        }


    }
}