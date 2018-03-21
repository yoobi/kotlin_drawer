package com.example.biscuit.mydrawer

import com.example.biscuit.mydrawer.com.example.biscuit.mydrawer.fragments.BtcViewInterface

interface BtcFragmentPresenter{

    fun refreshArticlesList()
}

class BtcFragmentPresenterImpl(val viewCallback: BtcViewInterface) : BtcFragmentPresenter{

    var service = ArticleService()

    override fun refreshArticlesList(){
        service.getArticles(object: ArticlesReceivedCallback{
            override fun onInternetError() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onArticlesReceived(articles: ArrayList<Articles>?) {
                viewCallback.onArticlesReceived(articles)
            }
        })
    }

}

interface ArticlesReceivedCallback {
    fun onArticlesReceived(articles: ArrayList<Articles>?)
    fun onInternetError()
}