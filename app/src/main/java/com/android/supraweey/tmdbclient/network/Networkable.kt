package com.android.supraweey.tmdbclient.network

import android.net.ConnectivityManager

interface Networkable {
    fun isInternetConnection(): Boolean
}