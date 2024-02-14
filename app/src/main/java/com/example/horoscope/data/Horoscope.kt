package com.example.horoscope.data

import com.example.horoscope.R

// Horoscope signs with the elementos they have, the icon and the name

sealed class Horoscope (val image:Int, val name:Int) {
    object Aries : Horoscope(R.drawable.ic_aries, R.string.horoscope_name_aries)
    object Taurus : Horoscope(R.drawable.ic_taurus, R.string.horoscope_name_taurus)
    object Gemini : Horoscope(R.drawable.ic_gemini, R.string.horoscope_name_gemini)
    object Cancer : Horoscope(R.drawable.ic_cancer, R.string.horoscope_name_cancer)
    object Leo : Horoscope(R.drawable.ic_leo, R.string.horoscope_name_leo)
    object Virgo : Horoscope(R.drawable.ic_virgo, R.string.horoscope_name_virgo)
    object Libra : Horoscope(R.drawable.ic_libra, R.string.horoscope_name_libra)
    object Scorpio : Horoscope(R.drawable.ic_scorpio, R.string.horoscope_name_scorpio)
    object Sagittarius : Horoscope(R.drawable.ic_sagittarius, R.string.horoscope_name_sagittarius)
    object Capricorn : Horoscope(R.drawable.ic_capricorn, R.string.horoscope_name_capricorn)
    object Aquarius : Horoscope(R.drawable.ic_aquarius, R.string.horoscope_name_aquarius)
    object Pisces : Horoscope(R.drawable.ic_pisces, R.string.horoscope_name_pisces)
}