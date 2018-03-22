package com.example.biscuit.mydrawer

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class TutoAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

//    private var data =

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> { Slide1Fragment() }
            1 -> { Slide2Fragment() }
            else -> { Slide1Fragment() }
        }
    }

    override fun getCount(): Int {
        return 2
    }


}