package com.example.laba14api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.json.JSONObject
import java.io.IOException
import java.net.URL
import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.net.ssl.HttpsURLConnection

class SetupPunchlineActivity : AppCompatActivity() {
    private lateinit var tvMain: TextView
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setup_punchline)
        tvMain = findViewById(R.id.tvMain)
        button = findViewById(R.id.btn)
        val executorService: ExecutorService = Executors.newSingleThreadExecutor()

        button.setOnClickListener {
            /*получение данных из потока для отображения в textView*/
            tvMain.text = executorService.submit(Callable {
                httpsRequest("https://official-joke-api.appspot.com/random_joke")
            }).get()
        }
    }
    @Throws(IOException::class)
    fun httpsRequest(urlString: String):String {
        val url = URL(urlString)
        val connection = url.openConnection() as HttpsURLConnection
        connection.requestMethod = "GET"
        var data: Int = connection.inputStream.read()
        var str = ""
        while (data != -1){
            str += data.toChar()
            data = connection.inputStream.read()
        }
        val mainObject = JSONObject(str)
        val item = Jokes(
            mainObject.getString("setup"),
            mainObject.getString("punchline")
        )
        val fullJoke: String = item.start_Joke + "\n-----------------\n" + item.end_Joke
        return fullJoke
    }
}