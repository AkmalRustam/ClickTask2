package com.akmal.clicktask2.util.extension

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView

fun Context.showMessage(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun ShapeableImageView.setImageWithGlideAndCircularProgress(image: String) {
    val circularProgressDrawable = CircularProgressDrawable(this.context).apply {
        strokeWidth = 5f
        centerRadius = 30f
        start()
    }
    Glide
        .with(this.context)
        .load(image)
        .placeholder(circularProgressDrawable)
        .into(this)
}