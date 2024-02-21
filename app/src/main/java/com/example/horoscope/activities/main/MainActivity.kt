package com.example.horoscope.activities.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscope.R
import com.example.horoscope.activities.detail.DetailActivity
import com.example.horoscope.adapters.HoroscopeAdapter
import com.example.horoscope.data.Horoscope
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

        // Set up of recyclerView and adapter

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

                // Don't search until push button. If not needed, return false is mandatory

                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                // Search while type, if empty show all the list, else filter list by string name

                override fun onQueryTextChange(query: String?): Boolean {
                    horoscopeList = if (query.isNullOrEmpty()) {
                        HoroscopeProvider.HoroscopeList().horoscopeList
                    } else {
                        HoroscopeProvider.HoroscopeList().horoscopeList.filter { getString(it.name).contains(query, true) }
                    }

                    // Update the list to all if empty, or to the ones containing the query

                    horoscopeAdapter.updateData(horoscopeList)
                    return true
                }
            })
        }
    }
    // This event will enable the back function to the button on press
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

        // Adding dynamically ID of Horoscope class

        intent.putExtra("HOROSCOPE_ID", horoscope.id)

        startActivity(intent)

        //Toast.makeText(this, getString(horoscope.name), Toast.LENGTH_LONG).show()

    }
}