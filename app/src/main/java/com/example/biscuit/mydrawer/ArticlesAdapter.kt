package com.example.biscuit.mydrawer

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.bumptech.glide.Glide

class ArticlesAdapter : RecyclerView.Adapter<ArticlesViewHolder>(){

    var articles = arrayListOf<Articles>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        val view = parent.inflate(R.layout.cell_article)
        return ArticlesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        val article = articles[position]
        val context = holder.itemView.context

        holder.articleTitle?.text = article.title
        Glide.with(context).load(article.image).into(holder.articleImage!!)
        holder.articleDetail?.text = article.description

        when(position) {
            0 -> holder.itemView.setOnClickListener({
                context.startActivity(Intent(context, DetailsArticleActivity::class.java))
            })
        }
    }


}
