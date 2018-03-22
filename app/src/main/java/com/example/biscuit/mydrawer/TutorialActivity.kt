package com.example.biscuit.mydrawer

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity

class TutorialActivity : AppCompatActivity(){

    var adapter: TutoAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)

        val viewPager = findViewById<ViewPager>(R.id.tutorial_viewPager)
        adapter = TutoAdapter(supportFragmentManager)
        viewPager.adapter = adapter
    }
}