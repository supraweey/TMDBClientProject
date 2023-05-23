package com.android.supraweey.tmdbclient.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast

class SchemeActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       handleDeepLink(intent?.action, intent?.data)
    }

    private fun handleDeepLink(appLinkAction: String?, appLinkData: Uri?){
        if(Intent.ACTION_VIEW == appLinkAction && appLinkData != null){
            showOffer(appLinkData)
        }
    }

    private fun showOffer(appLinkData: Uri){
        val drinkId = appLinkData.getQueryParameter("id")
        if(!drinkId.isNullOrBlank()){
            onCocktailClick(drinkId)
        }
        else {
            Toast.makeText(this, "ID doesn't exist", Toast.LENGTH_SHORT).show()
        }
    }

    private fun onCocktailClick(id: String){
        startActivity(Intent(this, MainActivity::class.java).putExtra("ID_KEY", id))
    }
}