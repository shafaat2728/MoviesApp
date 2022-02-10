package com.digitify.moviesapp.common

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.DialogFragmentNavigator
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import com.digitify.moviesapp.data.dto.Genres
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

fun Fragment.onBack() {
    view?.let { activity?.onBackPressed() }
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Int?.checkVisibility(): Boolean {
    return !(this == null || this == 0)
}

fun List<Genres>?.getGenres(): String {
    if (this.isNullOrEmpty())
        return ""
    var genres = ""
    this.forEach {
        genres += "${it.name}  "
    }
    return genres
}

fun Int?.getRunTime(): String {
    if (this == null)
        return ""
    val hours: Int = this / 60
    val minutes: Int = this % 60

    return "${hours}h ${minutes}min"
}

fun Double?.getAverageRating(): Int {
    if (this == null)
        return 0
    val rating=this * 10
    return rating.toInt()
}

fun Int?.getRevenue(): String {
    if (this == null) return ""
    if (this < 1000) return "" + this
    val exp = (Math.log(this.toDouble()) / Math.log(1000.0)).toInt()
    return String.format(
        "%.1f %c",
        this / Math.pow(1000.0, exp.toDouble()),
        "kMGTPE"[exp - 1]
    )
}


/**
 * Double click on button which navigate to Dialog Fragment crashes the app so we have to check if current
 * destination is equal to given destination
 * */

fun Fragment.safeNavigate(directions: NavDirections) {
    val navController = findNavController()
    when (val destination = navController.currentDestination) {
        is FragmentNavigator.Destination -> {
            if (javaClass.name == destination.className) {
                navController.navigate(directions)
            }
        }
        is DialogFragmentNavigator.Destination -> {
            if (javaClass.name == destination.className) {
                navController.navigate(directions)
            }
        }
    }
}

