package com.example.horoscope.data

import com.example.horoscope.R

sealed class Horoscope (val image:Int, val name:Int) {
    object Aries : Horoscope(R.drawable.ic_aries, R.string.horoscope_name_aries)
    object Taurus : Horoscope(R.drawable.ic_taurus, R.string.horoscope_name_taurus)
    /*class Aries(image: Int, name: Int) : Horoscope(image, name)
    class Taurus(image: Int, name: Int) : Horoscope(image, name)*/

}