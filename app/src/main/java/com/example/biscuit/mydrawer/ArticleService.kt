package com.example.biscuit.mydrawer

import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit



class ArticleService {


    init {
        val retrofit = Retrofit.Builder()
                        .baseUrl("https://www.crypto-france.com")
                        .client(OkHttpClient())
                        .addConverterFactory(SimpleXmlConverterFactory.create())
                        .build()

        val api =
    }

    fun getArticles(){

    }

}