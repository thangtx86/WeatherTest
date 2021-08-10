package io.github.thang86.weathertest.utils

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import io.github.thang86.weathertest.R
import io.github.thang86.weathertest.extensions.parseDate
import io.github.thang86.weathertest.extensions.round

/**
 *
 *    BindingUtils.kt
 *
 *    Created by ThangTX on 11/08/2021
 *
 */

@BindingAdapter("imageUrl")
fun ImageView.bindImage(stateAbbr: String?) {
    val image64 = (Constains.BASE_IMAGE_URL + Constains.IMAGE_64_PNG)
        .replace("X", stateAbbr ?: "")
    if (!stateAbbr.isNullOrEmpty())
        Glide.with(context)
            .load(image64)
            .apply(
                RequestOptions()
                    .error(R.drawable.ic_launcher_background)
            )
            .into(this)
    else setImageResource(R.drawable.ic_launcher_background)
}

@BindingAdapter("dateFormatted")
fun TextView.bindDate(date: String?) {
    text = date?.parseDate()
}

@SuppressLint("SetTextI18n")
@BindingAdapter("temperatureFormat")
fun TextView.bindTemperature(temperature: String?) {
    text = "${temperature?.round(1)} ${"\u2103"}"
}