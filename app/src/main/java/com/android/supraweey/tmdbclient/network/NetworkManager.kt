package com.android.supraweey.tmdbclient.network

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import androidx.annotation.RequiresApi

class NetworkManager private constructor(networkable: Networkable): Networkable by networkable {
    companion object{
        @RequiresApi(Build.VERSION_CODES.M)
        fun init(context: Context): NetworkManager{
            return NetworkManager(NetworkUtils(context.getSystemService(ConnectivityManager::class.java)))
        }
    }
}