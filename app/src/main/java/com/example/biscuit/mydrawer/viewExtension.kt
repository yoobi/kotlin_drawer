package com.example.biscuit.mydrawer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun ViewGroup.inflate(resId: Int) : View {
    return LayoutInflater.from(context).inflate(resId, this, false)
}