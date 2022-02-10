package com.digitify.moviesapp.common

import android.content.Context
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

fun String?.checkCurrentYear(): Boolean {
    return try {
        val year = Calendar.getInstance().get(Calendar.YEAR)
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
        val date: Date = dateFormat.parse(this)

        val calendar = Calendar.getInstance()
        calendar.time = date
        val movieYear = calendar.get(Calendar.YEAR)
        year == movieYear
    } catch (e: Exception) {

        false
    }
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}