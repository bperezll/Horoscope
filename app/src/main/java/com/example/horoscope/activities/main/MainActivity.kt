package com.example.horoscope.activities.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscope.R
import com.example.horoscope.activities.detail.DetailActivity
import com.example.horoscope.adapters.HoroscopeAdapter
import com.example.horoscope.data.Horoscope
import com.example.horoscope.data.Horoscope.Aquarius.name
import com.example.horoscope.data.HoroscopeProvider

class MainActivity : AppCompatActivity() {

    private var horoscopeList = HoroscopeProvider.HoroscopeList().horoscopeList

    private lateinit var horoscopeAdapter:HoroscopeAdapter

    private lateinit var  recyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

    }

    private fun initView() {

        recyclerView = findViewById(R.id.recyclerView)

        horoscopeAdapter = HoroscopeAdapter(HoroscopeProvider.HoroscopeList().horoscopeList) {
            onItemClickListener(it)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)

        //recyclerView.layoutManager = GridLayoutManager(this, 2)

        recyclerView.adapter = horoscopeAdapter
    }

    private fun initSearchView(searchItem: MenuItem?) {
        if (searchItem != null) {
            val searchView = searchItem.actionView as SearchView

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(query: String?): Boolean {
                    horoscopeList = if (query.isNullOrEmpty()) {
                        HoroscopeProvider.HoroscopeList().horoscopeList
                    } else {
                        HoroscopeProvider.HoroscopeList().horoscopeList.filter { getString(it.name).contains(query, true) }
                    }
                    horoscopeAdapter.updateData(horoscopeList)
                    return true
                }
            })
        }
    }

    /*override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }*/

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.horoscope_menu, menu)

        initSearchView(menu?.findItem(R.id.menu_search))

        return true
    }

    private fun onItemClickListener(position:Int) {

        // Intent to go to the DetailActivity

        val horoscope:Horoscope = horoscopeList[position]

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