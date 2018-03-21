package com.example.biscuit.mydrawer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import kotlinx.android.synthetic.main.activity_webview.*

class WebViewActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_webview)
//        val webView = findViewById<WebView>(R.id.wv)
//        webView.loadUrl(intent.extras.getString("url"))
        wv.loadUrl("http://www.google.fr")

    }
}
