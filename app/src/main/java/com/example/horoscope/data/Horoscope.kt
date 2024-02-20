package com.example.horoscope.data

import com.example.horoscope.R

// Horoscope signs with the elementos they have, the icon and the name. Added id and date

sealed class Horoscope (val image:Int, val name:Int, val id:String, val date:Int) {
    object Aries : Horoscope(R.drawable.ic_aries, R.string.horoscope_name_aries, id = "aries", R.string.horoscope_date_aries)
    object Taurus : Horoscope(R.drawable.ic_taurus, R.string.horoscope_name_taurus, id = "taurus", R.string.horoscope_date_taurus)
    object Gemini : Horoscope(R.drawable.ic_gemini, R.string.horoscope_name_gemini, id = "gemini", R.string.horoscope_date_gemini)
    object Cancer : Horoscope(R.drawable.ic_cancer, R.string.horoscope_name_cancer, id = "cancer", R.string.horoscope_date_cancer)
    object Leo : Horoscope(R.drawable.ic_leo, R.string.horoscope_name_leo, id = "leo", R.string.horoscope_date_leo)
    object Virgo : Horoscope(R.drawable.ic_virgo, R.string.horoscope_name_virgo, id = "virgo", R.string.horoscope_date_virgo)
    object Libra : Horoscope(R.drawable.ic_libra, R.string.horoscope_name_libra, id = "libra", R.string.horoscope_date_libra)
    object Scorpio : Horoscope(R.drawable.ic_scorpio, R.string.horoscope_name_scorpio, id = "scorpio", R.string.horoscope_date_scorpio)
    object Sagittarius : Horoscope(R.drawable.ic_sagittarius, R.string.horoscope_name_sagittarius, id = "sagittarius", R.string.horoscope_date_sagittarius)
    object Capricorn : Horoscope(R.drawable.ic_capricorn, R.string.horoscope_name_capricorn, id = "capricorn", R.string.horoscope_date_capricorn)
    object Aquarius : Horoscope(R.drawable.ic_aquarius, R.string.horoscope_name_aquarius, id = "aquarius", R.string.horoscope_date_aquarius)
    object Pisces : Horoscope(R.drawable.ic_pisces, R.string.horoscope_name_pisces, id = "pisces", R.string.horoscope_date_pisces)
}