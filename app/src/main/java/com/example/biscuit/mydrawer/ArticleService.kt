package com.example.biscuit.mydrawer

import android.util.Log
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit



class ArticleService {

    private var api: ApiInterface?

    init {
        val retrofit = Retrofit.Builder()
                        .baseUrl("https://www.crypto-france.com")
                        .client(OkHttpClient())
                        .addConverterFactory(SimpleXmlConverterFactory.create())
                        .build()

        api = retrofit.create(ApiInterface::class.java)
    }

    fun getBitcoinArticles(callback: ArticlesReceivedCallback) {
        api?.getBitcoinArticles()?.enqueue(object: Callback<ArticlesObjectResponse>{
            override fun onFailure(call: Call<ArticlesObjectResponse>?, t: Throwable?) {
                callback.onInternetError()
            }

            override fun onResponse(call: Call<ArticlesObjectResponse>?, response: Response<ArticlesObjectResponse>?) {
                val image = response?.body()?.channel?.image
                val articles = response?.body()?.channel?.articles
                articles?.forEach {
                    it.urlImage = image?.urlImage
                }
                callback.onArticlesReceived(articles)
            }

        })

    }

    fun getEthereumArticles(callback: ArticlesReceivedCallback) {
        api?.getEthereumArticles()?.enqueue(object: Callback<ArticlesObjectResponse>{
            override fun onFailure(call: Call<ArticlesObjectResponse>?, t: Throwable?) {
                callback.onInternetError()
            }

            override fun onResponse(call: Call<ArticlesObjectResponse>?, response: Response<ArticlesObjectResponse>?) {
                val image = response?.body()?.channel?.image
                val articles = response?.body()?.channel?.articles
                articles?.forEach {
                    it.urlImage = image?.urlImage
                }
                callback.onArticlesReceived(articles)
            }

        })

    }

}