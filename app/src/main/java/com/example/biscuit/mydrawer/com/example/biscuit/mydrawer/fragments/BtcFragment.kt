package com.example.biscuit.mydrawer.com.example.biscuit.mydrawer.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.biscuit.mydrawer.*

class BtcFragment : Fragment(), BtcViewInterface {
    var presenter: BtcFragmentPresenter = BtcFragmentPresenterImpl(this)
    private var adapter: ArticlesAdapter = ArticlesAdapter()
    private var pullToRefresh: SwipeRefreshLayout? = null

    override fun onArticlesReceived(articles: ArrayList<Articles>?) {
        adapter.articles = articles
        adapter.notifyDataSetChanged()
        pullToRefresh?.isRefreshing = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.refreshArticlesList()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView =  inflater.inflate(R.layout.btc_fragment, container, false)
        val rv = rootView.findViewById<RecyclerView>(R.id.articles_rv)
        pullToRefresh = rootView.findViewById<SwipeRefreshLayout>(R.id.swipeRefreshLayout)

        pullToRefresh?.setOnRefreshListener {
            presenter.refreshArticlesList()
        }

        rv.layoutManager = LinearLayoutManager(context)
        adapter = ArticlesAdapter()
        rv.adapter = adapter

        return rootView
    }

}

interface BtcViewInterface {
    fun onArticlesReceived(articles: ArrayList<Articles>?)
}
