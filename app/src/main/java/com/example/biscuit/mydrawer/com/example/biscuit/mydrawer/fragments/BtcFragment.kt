package com.example.biscuit.mydrawer.com.example.biscuit.mydrawer.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.biscuit.mydrawer.R

/**
 * Created by Biscuit on 19/03/2018.
 */

class BtcFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView =  inflater!!.inflate(R.layout.btc_fragment, container, false)
        val tv = rootView.findViewById<TextView>(R.id.textviewTest)
        return rootView
    }
}