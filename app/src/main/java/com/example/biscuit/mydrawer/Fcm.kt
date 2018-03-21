package com.example.biscuit.mydrawer

import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService

class Fcm : FirebaseInstanceIdService(){

    override fun onTokenRefresh(){
        var refreshedToken: String? = FirebaseInstanceId.getInstance().getToken()
        Log.d("FCM", "Refreshed token" + refreshedToken)

    }




}