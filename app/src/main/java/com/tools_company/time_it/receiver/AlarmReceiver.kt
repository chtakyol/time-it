package com.tools_company.time_it.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.tools_company.time_it.utils.createAlarmReceiverNotification

class AlarmReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, p1: Intent?) {
        Log.d("AlarmReceiver", "onReceive")
        context?.createAlarmReceiverNotification()
    }
}