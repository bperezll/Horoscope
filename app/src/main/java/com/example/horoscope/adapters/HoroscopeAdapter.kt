package com.example.horoscope.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscope.R
import com.example.horoscope.data.Horoscope

class HoroscopeAdapter(private var items:List<Horoscope> = listOf(), val onClickListener : (position:Int) -> Unit) : RecyclerView.Adapter<HoroscopeViewHolder>() {

    // Update items on Search
    fun updateData(list :List<Horoscope>) {
        this.items = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope, parent, false)
        return HoroscopeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        holder.render(items[position])
        holder.itemView.setOnClickListener { onClickListener(position) }
    }
}

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val horoscopeImageView:ImageView = view.findViewById(R.id.horoscopeImageView)
    private val horoscopeTextView:TextView = view.findViewById(R.id.horoscopeTextView)
    fun render(horoscope: Horoscope) {
        val context:Context = itemView.context
        horoscopeTextView.text = context.getString(horoscope.name)
        horoscopeImageView.setImageResource(horoscope.image)
    }
}