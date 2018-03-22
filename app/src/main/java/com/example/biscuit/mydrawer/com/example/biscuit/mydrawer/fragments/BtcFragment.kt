package com.example.biscuit.mydrawer.com.example.biscuit.mydrawer.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.biscuit.mydrawer.*
import com.afollestad.materialdialogs.MaterialDialog



class BtcFragment : Fragment(), BtcViewInterface {


    var presenter: BtcFragmentPresenter = BtcFragmentPresenterImpl(this)
    private var adapter: ArticlesAdapter = ArticlesAdapter()
    private var pullToRefresh: SwipeRefreshLayout? = null
    private var materialDialog: MaterialDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        val readTuto = pref.getBoolean("hasReadTuto", false)
        if(!readTuto)
            startActivity(Intent(context, TutorialActivity::class.java))

        presenter.refreshArticlesList()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView =  inflater.inflate(R.layout.btc_fragment, container, false)
        val rv = rootView.findViewById<RecyclerView>(R.id.articles_rv)
        pullToRefresh = rootView.findViewById(R.id.swipeRefreshBtcLayout)

        pullToRefresh?.setOnRefreshListener {
            presenter.refreshArticlesList()
        }

        rv.layoutManager = LinearLayoutManager(rootView.context)
        adapter = ArticlesAdapter()
        rv.adapter = adapter

        return rootView
    }


    override fun onArticlesReceived(articles: ArrayList<Articles>?) {
        adapter.articles = articles
        adapter.notifyDataSetChanged()
        pullToRefresh?.isRefreshing = false
    }

    override fun onDismissLoading() {
        materialDialog?.dismiss()
    }
    override fun onShowLoading() {
        materialDialog = MaterialDialog.Builder(context!!)
                .title("Attente")
                .content("Attends ca cuit !")
                .progress(true, 0)
                .cancelable(false)
                .canceledOnTouchOutside(false)
                .show()
    }

}

interface BtcViewInterface {
    fun onArticlesReceived(articles: ArrayList<Articles>?)
    fun onShowLoading()
    fun onDismissLoading()
}
