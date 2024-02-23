package com.example.horoscope.activities.detail

import android.content.ClipData.Item
import android.content.DialogInterface
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.horoscope.R
import com.example.horoscope.data.Horoscope
import com.example.horoscope.data.HoroscopeProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {

    // To use with coroutine for the API text

    private var horoscopeId:String? = null

    private lateinit var horoscope:Horoscope

    private lateinit var horoscopeTextView:TextView
    private lateinit var horoscopeImageView:ImageView
    private lateinit var horoscopeLuckTextView:TextView
    private lateinit var horoscopeDateTextView:TextView

    private var detailNavigation:Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initView()
        loadData()
    }

    private fun initView() {

        // Get the ID of every Zodiac sign, only intent needed

        horoscopeId = intent.getStringExtra("HOROSCOPE_ID")
        horoscope = HoroscopeProvider().getHoroscope(horoscopeId!!)
        detailNavigation = HoroscopeProvider().getHoroscopeIndex(horoscope)

        // Display the selected Zodiac sign

        horoscopeTextView = findViewById(R.id.horoscopeTextView)
        horoscopeTextView.text = getString(horoscope.name)

        // Display the selected Zodiac icon

        horoscopeImageView = findViewById(R.id.horoscopeImageView)
        horoscopeImageView.setImageResource(horoscope.image)

        // Display date range text of the sign

        horoscopeDateTextView = findViewById(R.id.horoscopeDateTextView)
        horoscopeDateTextView.text = getString(horoscope.date)

        // Display the API text of Zodiac signs

        horoscopeLuckTextView = findViewById(R.id.horoscopeLuckTextView)
        horoscopeTextView.text = horoscopeId
    }

    private fun loadData() {
        horoscope = HoroscopeProvider().getHoroscope(detailNavigation)

        horoscopeTextView.text = getString(horoscope.name)
        horoscopeImageView.setImageResource(horoscope.image)
        horoscopeDateTextView.text = getString(horoscope.date)

        // Run coroutine
        getHoroscopeLuck()
    }

    private fun getHoroscopeLuck() {
        horoscopeLuckTextView.text = ""
        CoroutineScope(Dispatchers.IO).launch {
            // Llamada en segundo plano
            val result = HoroscopeProvider().getHoroscopeLuck(horoscope.id)
            runOnUiThread {
                // Modificar UI
                horoscopeLuckTextView.text = result
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.detail_menu, menu)

        // Show back button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        return true
    }


    // This event will enable the back function to the button on press
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }

            R.id.btnPrev -> {
                if (detailNavigation == 0) {
                    detailNavigation = HoroscopeProvider.HoroscopeList().horoscopeList.size
                }
                detailNavigation--
                loadData()
                return true
            }
            /*R.id.btnNext -> {
                detailNavigation ++
                if (detailNavigation == HoroscopeProvider.HoroscopeList().horoscopeList.size) {
                        detailNavigation = 0
                }

                horoscope = HoroscopeProvider.HoroscopeList().horoscopeList[detailNavigation]

                return true
            }*/
            //R.id.btnPrev -> detailNavigation--
            //R.id.btnNext -> detailNavigation++


        }
        return super.onOptionsItemSelected(item)
    }

    private fun showErrorDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder
            .setTitle("Error")
            .setMessage("Hubo un error conectando con el servicio")
            //.setCancelable(false)
            .setPositiveButton("Vale") { dialog, _ -> dialog?.cancel() }

        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}
