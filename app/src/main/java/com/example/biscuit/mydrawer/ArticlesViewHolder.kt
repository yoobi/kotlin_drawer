package com.example.biscuit.mydrawer

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class ArticlesViewHolder(itemView: View) : ViewHolder(itemView) {

    var articleImage: ImageView? = itemView.findViewById(R.id.articles_imv)
    var articleTitle: TextView? = itemView.findViewById(R.id.articles_title)
    var articleDetail: TextView? = itemView.findViewById(R.id.articles_detail)



}