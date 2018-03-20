package com.example.biscuit.mydrawer.com.example.biscuit.mydrawer.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.biscuit.mydrawer.ArticlesAdapter
import com.example.biscuit.mydrawer.BtcFragmentPresenter
import com.example.biscuit.mydrawer.R

class BtcFragment : Fragment() {

    var BtcFragmentPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView =  inflater.inflate(R.layout.btc_fragment, container, false)
        val rv = rootView.findViewById<RecyclerView>(R.id.articles_rv)
        rv.layoutManager = LinearLayoutManager(context)
        rv.adapter = ArticlesAdapter()

        return rootView
    }
}