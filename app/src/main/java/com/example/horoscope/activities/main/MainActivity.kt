package com.example.horoscope.activities.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscope.R
import com.example.horoscope.activities.detail.DetailActivity
import com.example.horoscope.adapters.HoroscopeAdapter
import com.example.horoscope.data.Horoscope
import com.example.horoscope.data.HoroscopeProvider

class MainActivity : AppCompatActivity() {

    private lateinit var adapter:HoroscopeAdapter

    private lateinit var  recyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

    }

    private fun initView() {

        recyclerView = findViewById(R.id.recyclerView)

        adapter = HoroscopeAdapter(HoroscopeProvider.HoroscopeList().horoscopeList) {
            onItemClickListener(it)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)

        //recyclerView.layoutManager = GridLayoutManager(this, 2)

        recyclerView.adapter = adapter
    }

    private fun onItemClickListener(position:Int) {

        // Intent to go to the DetailActivity

        val horoscope:Horoscope = HoroscopeProvider.HoroscopeList().horoscopeList[position]

        val intent = Intent(this, DetailActivity::class.java)

        // Adding dynamically parts of Horoscope class

        intent.putExtra("HOROSCOPE_NAME", getString(horoscope.name))
        intent.putExtra("HOROSCOPE_ID", horoscope.id)
        intent.putExtra("HOROSCOPE_IMAGE", horoscope.image)
        intent.putExtra("HOROSCOPE_DATE", getString(horoscope.date))

        startActivity(intent)

        //Toast.makeText(this, getString(horoscope.name), Toast.LENGTH_LONG).show()

    }
}