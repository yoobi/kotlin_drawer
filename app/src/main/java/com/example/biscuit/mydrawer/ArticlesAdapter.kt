package com.example.biscuit.mydrawer

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.bumptech.glide.Glide

class ArticlesAdapter : RecyclerView.Adapter<ArticlesViewHolder>(){

    var articles: List<Articles>? = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        val view = parent.inflate(R.layout.cell_article)
        return ArticlesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if(articles == null) {
            0
        } else{
            articles!!.size
        }
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        val article = articles?.get(position)
        val context = holder.itemView.context

        holder.articleTitle?.text = article?.title
        Glide.with(context).load(article?.urlImage).into(holder.articleImage!!)
        holder.articleDetail?.text = article?.description
        holder.articleLink?.text = article?.link

        when(position) {
            0 -> holder.itemView.setOnClickListener({
                context.startActivity(Intent(context, DetailsArticleActivity::class.java))
            })
        }
    }


}
