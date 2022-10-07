package com.tools_company.time_it.utils

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.text.format.DateFormat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.tools_company.time_it.R
import com.tools_company.time_it.receiver.AlarmReceiver
import java.util.*

fun Long.toHumanReadableDate(): String {
    return DateFormat.format("dd/MM/yyyy", Date(this)).toString()
}

internal fun Context.setAlarm(date: Date) {
    val alarmManager = this.getSystemService(Context.ALARM_SERVICE) as? AlarmManager
    val alarmIntent = Intent(this, AlarmReceiver::class.java)
    val alarmPendingIntent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        PendingIntent.getBroadcast(this, 1, alarmIntent, PendingIntent.FLAG_IMMUTABLE)
    } else {
        TODO("VERSION.SDK_INT < M")
    }

    alarmManager?.setInexactRepeating(
        AlarmManager.RTC_WAKEUP,
        date.time,
        AlarmManager.INTERVAL_DAY,
        alarmPendingIntent
    )
}

internal fun Context.createAlarmReceiverNotification() {
    val builder = NotificationCompat.Builder(this, "Main Channel ID")
        .setContentTitle("Time It")
        .setSmallIcon(R.drawable.ic_baseline_notifications_active_24)
        .setPriority(NotificationCompat.PRIORITY_LOW)

    val notificationManager = NotificationManagerCompat.from(this)

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel(
            "Main Channel ID",
            "Main Channel",
            NotificationManager.IMPORTANCE_LOW
        )
        notificationManager.createNotificationChannel(channel)

        notificationManager.notify(
            1,
            builder.build()
        )
    }
}