package com.jppedrosa.vexillology.common.extensions

import androidx.appcompat.widget.AppCompatImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jppedrosa.vexillology.R

/**
 * @author João Pedro Pedrosa (<a href="mailto:joaopopedrosa@gmail.com">joaopopedrosa@gmail.com</a>) on 15/09/2022.
 */

fun AppCompatImageView.load(url: String?) {
    val loadingView = CircularProgressDrawable(this.context).apply {
        strokeWidth = 4f
        centerRadius = 20f
        start()
    }

    val glideOptions = RequestOptions()
        .placeholder(loadingView)
        .centerCrop()
        .error(R.mipmap.ic_launcher) //TODO Change this

    Glide.with(this)
        .setDefaultRequestOptions(glideOptions)
        .load(url)
        .into(this)
}