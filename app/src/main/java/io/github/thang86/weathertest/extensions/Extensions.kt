package io.github.thang86.weathertest.extensions

import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.round

/**
 *
 *    Extensions.kt
 *
 *    Created by ThangTX on 11/08/2021
 *
 */

/**
 * The functions use round number
 */
fun String.round(number: Int): Double {
    var multiplier = 1.0
    repeat(number) { multiplier *= 10 }
    return round((this.toDouble()) * multiplier) / multiplier
}

/**
 * The extension functions use parse date for format
 */
fun String.parseDate(): String {
    val patternInput = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
    val patternOutput = SimpleDateFormat("EEE MMM d, yyyy", Locale.ENGLISH)
    var newDate = ""
    try {
        val dt = patternInput.parse(this)
        newDate = patternOutput.format(dt)
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return newDate
}
fun Calendar.getCurrentDate():String{
    return SimpleDateFormat("yyyy/M/dd").format(this.time)
}