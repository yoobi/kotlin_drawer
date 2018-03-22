package com.example.biscuit.mydrawer

import com.example.biscuit.mydrawer.com.example.biscuit.mydrawer.fragments.BtcViewInterface

interface BtcFragmentPresenter{

    fun refreshArticlesList()
}

class BtcFragmentPresenterImpl(val viewCallback: BtcViewInterface) : BtcFragmentPresenter{

    var service = ArticleService()

    override fun refreshArticlesList(){
        viewCallback.onShowLoading()
        service.getBitcoinArticles(object: ArticlesReceivedCallback{
            override fun onInternetError() {
                viewCallback.onDismissLoading()
            }

            override fun onArticlesReceived(articles: ArrayList<Articles>?) {
                viewCallback.onArticlesReceived(articles)
                viewCallback.onDismissLoading()
            }
        })
    }

}

interface ArticlesReceivedCallback {
    fun onArticlesReceived(articles: ArrayList<Articles>?)
    fun onInternetError()
}