package com.example.biscuit.mydrawer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import android.webkit.WebViewClient

class WebViewActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_webview)
        val url = intent.getStringExtra("url")
        val webview = findViewById<WebView>(R.id.webview)
        webview.webViewClient = WebViewClient()
        webview.loadUrl(url)

    }
}
