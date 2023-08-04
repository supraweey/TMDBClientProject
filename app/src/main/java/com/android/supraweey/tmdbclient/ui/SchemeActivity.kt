package com.android.supraweey.tmdbclient.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import com.android.supraweey.tmdbclient.R
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.dynamiclinks.ktx.dynamicLinks
import com.google.firebase.ktx.Firebase

class SchemeActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        handleDeepLink(intent?.action, intent?.data)

        handleFirebaseDynamicLinks(intent)
    }

    private fun handleDeepLink(appLinkAction: String?, appLinkData: Uri?) {
        if (Intent.ACTION_VIEW == appLinkAction && appLinkData != null) {
            showOffer(appLinkData)
        }
    }

    private fun handleFirebaseDynamicLinks(intent: Intent) {
        FirebaseAnalytics.getInstance(this)
        Firebase.dynamicLinks.getDynamicLink(intent)
            .addOnSuccessListener { dynamicLinkData ->
                if (dynamicLinkData != null) {
                    showOffer(dynamicLinkData.link)
                }
            }
            .addOnFailureListener(this) {
                Toast.makeText(this, R.string.error_an_error_occur, Toast.LENGTH_SHORT).show()
            }
    }

    private fun showOffer(appLinkData: Uri?) {
        val drinkId = appLinkData?.getQueryParameter("id")
        if (!drinkId.isNullOrBlank()) {
            onCocktailClick(drinkId)
        } else {
            Toast.makeText(this, R.string.error_id_not_exist, Toast.LENGTH_SHORT).show()
        }
    }

    private fun onCocktailClick(id: String) {
        startActivity(Intent(this, PopularActivity::class.java).putExtra("ID_KEY", id))
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        intent?.let { newIntent ->
            handleDeepLink(newIntent.action, newIntent.data)
        }
    }
}