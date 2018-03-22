package com.example.biscuit.mydrawer

import com.example.biscuit.mydrawer.com.example.biscuit.mydrawer.fragments.ethViewInterface

interface EthFragmentPresenter {
    fun refreshArticlesList()
}

class EthFragmentPresenterImpl(val ethView: ethViewInterface) : EthFragmentPresenter {

    var service = ArticleService()

    override fun refreshArticlesList() {
        service.getEthereumArticles(object: ArticlesReceivedCallback{
            override fun onArticlesReceived(articles: ArrayList<Articles>?) {
                ethView.onArticlesReceived(articles)
            }

            override fun onInternetError() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })


    }
}