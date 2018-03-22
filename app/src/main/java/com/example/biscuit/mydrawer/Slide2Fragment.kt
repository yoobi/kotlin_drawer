package com.example.biscuit.mydrawer

import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class Slide2Fragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view: View = inflater.inflate(R.layout.fragment_slide2, container, false)
        val btn = view.findViewById<Button>(R.id.slide2_btn)

        btn.setOnClickListener {
            writeIntoPref(it)
        }

        return view
    }

    fun writeIntoPref(viewObj: View){
        val sP = PreferenceManager.getDefaultSharedPreferences(viewObj.context)
        sP!!.edit().putBoolean("hasReadTuto", true).apply()
    }
}