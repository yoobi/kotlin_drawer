package com.example.biscuit.mydrawer

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("/bitcoin/feed")
    fun getBitcoinArticles() : Call<ArticlesObjectResponse>

    @GET("/ethereum/feed")
    fun getEthereumArticles() : Call<ArticlesObjectResponse>

}