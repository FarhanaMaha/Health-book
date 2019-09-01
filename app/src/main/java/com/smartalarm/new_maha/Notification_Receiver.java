package com.smartalarm.new_maha;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.content.WakefulBroadcastReceiver;

/**
 * Created by MAHA on 1/18/2019.
 */

public class Notification_Receiver extends WakefulBroadcastReceiver {

    static Ringtone ringtone = null;

    @Override
    public void onReceive(Context context, Intent intent) {


        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alarmUri == null) {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        ringtone = RingtoneManager.getRingtone(context, alarmUri);
        // ringtone.play();




        //this will send a notification message
        ComponentName comp = new ComponentName(context.getPackageName(),
                Notification_Service.class.getName());
        startWakefulService(context, (intent.setComponent(comp)));
        setResultCode(Activity.RESULT_OK);


    }
}
