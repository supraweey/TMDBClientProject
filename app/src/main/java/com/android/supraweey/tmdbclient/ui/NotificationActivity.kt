package com.android.supraweey.tmdbclient.ui

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.android.supraweey.tmdbclient.R
import com.android.supraweey.tmdbclient.databinding.ActivityStartScreenBinding
import kotlin.random.Random

class NotificationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartScreenBinding
    private val CHANNEL_ID = "ChannelID"
    private val CHANNEL_NAME = "ChannelName"
    private val NOTIFICATION_ID = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNotification.setOnClickListener {
            setNotification()
        }
    }

    private fun setNotification() {
        createNotificationChannel()

        val intent = Intent(this, NotificationActivity::class.java)
        val notificationOrderId = Random.nextInt(0, 4999)
        val pendingIntent = getPendingIntent(intent, notificationOrderId)
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Awesome")
            .setContentText("This is the content text")
            .setSmallIcon(R.drawable.ic_star)
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(NOTIFICATION_ID, builder)
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                lightColor = Color.GREEN
                enableLights(true)
                setShowBadge(true)
            }
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }

    }

    private fun getPendingIntent(intent: Intent, notificationID: Int): PendingIntent =
        PendingIntent.getActivity(
            applicationContext,
            notificationID,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

}
