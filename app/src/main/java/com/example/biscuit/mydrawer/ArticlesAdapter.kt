package com.example.biscuit.mydrawer

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

class ArticlesAdapter : RecyclerView.Adapter<ArticlesViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        val view = parent.inflate(R.layout.cell_article)
        return ArticlesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder?, position: Int) {

    }


}
