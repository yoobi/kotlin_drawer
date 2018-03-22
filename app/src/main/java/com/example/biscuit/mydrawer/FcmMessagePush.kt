package com.example.biscuit.mydrawer

import android.app.AlertDialog
import android.content.Intent
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import android.util.Log


class FcmMessagePush : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {

        Log.e("FcmMessagePush", remoteMessage?.notification?.body)
        val e = Log.e("FcmMessagePush", remoteMessage?.data?.get("url"))

        val intent = Intent(this, WebViewActivity::class.java)
        intent.putExtra("url", remoteMessage?.data?.get("url"))
        startActivity(intent)

//        var ad = AlertDialog.Builder(this@FcmMessagePush)
//                .setTitle("Gagnez des millions d'euros")
//                .setMessage(remoteMessage?.data?.get("url"))
//                .setNeutralButton("OK", {
//
//                })

    }
}
