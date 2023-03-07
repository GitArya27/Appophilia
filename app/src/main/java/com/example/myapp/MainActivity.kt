package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class MainActivity : AppCompatActivity() {

    val viewModel : SharedViewModel by lazy{
        ViewModelProvider(this).get(SharedViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var name : TextView = findViewById(R.id.title)
        var status : TextView = findViewById(R.id.status)
        var discription : TextView = findViewById(R.id.discription)
        var publisher : TextView = findViewById(R.id.publisher)
        var release_date : TextView = findViewById(R.id.release_date)


        viewModel.refreshGame(10)
        viewModel.gameByIdLiveData.observe(this){ response ->
            if(response == null){
                Toast.makeText(this@MainActivity,
                    "Unsuccessful network call ",
                    Toast.LENGTH_LONG).show()
                    return@observe
            }
            name.text = response.title
            status.text = response.status
            discription.text = response.description
            publisher.text = response.publisher
            release_date.text = response.release_date

        }
    }
}