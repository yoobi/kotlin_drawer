package com.example.biscuit.mydrawer.com.example.biscuit.mydrawer.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import com.example.biscuit.mydrawer.*

class EthFragment : Fragment(), ethViewInterface {

    var presenter: EthFragmentPresenter = EthFragmentPresenterImpl(this)
    private var adapter: ArticlesAdapter = ArticlesAdapter()
    private var swipeLayout: SwipeRefreshLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.refreshArticlesList()

    }

    override fun onArticlesReceived(articles: ArrayList<Articles>?) {
        adapter.articles = articles
        adapter.notifyDataSetChanged()
        swipeLayout?.isRefreshing = false

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.btc_fragment, container, false)
        val rv = rootView.findViewById<RecyclerView>(R.id.articles_rv)
        swipeLayout = rootView.findViewById(R.id.swipeRefreshBtcLayout)
        swipeLayout?.setOnRefreshListener {
            presenter.refreshArticlesList()
        }

        rv.layoutManager = LinearLayoutManager(rootView.context)
        rv.adapter = adapter

        return rootView
    }

}

interface ethViewInterface {
    fun onArticlesReceived(articles: ArrayList<Articles>?)
}
