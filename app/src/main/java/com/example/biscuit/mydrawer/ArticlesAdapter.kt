package com.example.biscuit.mydrawer

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

class ArticlesAdapter : RecyclerView.Adapter<ArticlesViewHolder>(){

    companion object {
        val data = arrayListOf<String>("titre1","titre2","titre3")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        val view = parent.inflate(R.layout.cell_article)
        return ArticlesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        holder.articleTitle?.text = data[position]
    }


}
