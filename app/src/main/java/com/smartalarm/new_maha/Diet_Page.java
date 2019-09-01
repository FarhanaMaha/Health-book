package com.smartalarm.new_maha;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;

public class Diet_Page extends AppCompatActivity {
    private RadioGroup radioGroup;
    public RadioButton gain_weight, maintain_weight, loss_weight;
    public Context context;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    boolean a, b, c, d, e;
    AlarmManager am;
    PendingIntent pendingIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet__page);
        gain_weight = (RadioButton) findViewById(R.id.gain_weight);
        maintain_weight = (RadioButton) findViewById(R.id.maintain_weight);
        loss_weight = (RadioButton) findViewById(R.id.loss_weight);

        sharedPref = getSharedPreferences("type", Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        editor.remove("types");
        editor.commit();



        gain_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editor.putString("types","gain");
                editor.commit();
//                Calendar calendar = Calendar.getInstance();
//                calendar.setTimeInMillis(System.currentTimeMillis());
//                calendar.set(Calendar.HOUR_OF_DAY, 21);
//                calendar.set(Calendar.MINUTE, 5);
//                calendar.set(Calendar.SECOND, 10);
//                Intent intent = new Intent(Diet_Page.this, Notification_Receiver.class);
//                PendingIntent pendingIntent = PendingIntent.getBroadcast(Diet_Page.this, 0, intent, 0);
//                AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
//                am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
                Toast.makeText(getApplicationContext(), " Select Gain Weight ", Toast.LENGTH_SHORT).show();
            }
        });
        maintain_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editor.putString("types", "maintain");
                editor.commit();
                Toast.makeText(getApplicationContext(), " Select Maintain Weight ", Toast.LENGTH_SHORT).show();

                //  Intent intent = new Intent(Diet_Page.this, MainActivity.class);
                //  startActivity(intent);

            }
        });
        loss_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("types", "loss");
                editor.commit();

                Toast.makeText(getApplicationContext(), " Select Loss Weight", Toast.LENGTH_SHORT).show();


            }
        });


    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater manuinflater = getMenuInflater();
        manuinflater.inflate(R.menu.menu_list, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();

        int id = item.getItemId();
        if (id == R.id.notify_save){
//            am = (AlarmManager) getSystemService(ALARM_SERVICE);
//            intent = new Intent(Diet_Page.this, Notification_Receiver.class); // AlarmReceiver1 = broadcast receiver
//
//            pendingIntent = PendingIntent.getBroadcast(  Diet_Page.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//            intent.setData((Uri.parse("custom://"+System.currentTimeMillis())));
//            am.cancel(pendingIntent);
//
//            Calendar alarmStartTime = Calendar.getInstance();
//            Calendar now = Calendar.getInstance();
//            alarmStartTime.set(Calendar.HOUR_OF_DAY, 8);
//            alarmStartTime.set(Calendar.MINUTE, 00);
//            alarmStartTime.set(Calendar.SECOND, 0);
//            if (now.after(alarmStartTime)) {
//                alarmStartTime.add(Calendar.DATE, 1);
//            }
//
//            am.setRepeating(AlarmManager.RTC_WAKEUP, alarmStartTime.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);

//
//         calendar.set(Calendar.AM_PM,calendar.PM);
//        Intent intent = new Intent(Diet_Page.this, Notification_Receiver.class);
//         pendingIntent = PendingIntent.getBroadcast(Diet_Page.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//         am = (AlarmManager) getSystemService(ALARM_SERVICE);
//            am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
            Calendar calendar = Calendar.getInstance();
           // calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.set(Calendar.HOUR_OF_DAY, 6);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.AM_PM,Calendar.AM);
            Intent intent = new Intent(Diet_Page.this, Notification_Receiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(Diet_Page.this, 0, intent, 0);
                AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
                am.setRepeating(AlarmManager.RTC, calendar.getTimeInMillis(), 1000 * 60 *60*4, pendingIntent);


//            Calendar calendar2 = Calendar.getInstance();
//             calendar2.setTimeInMillis(System.currentTimeMillis());
//            calendar2.set(Calendar.HOUR_OF_DAY, 3);
//            calendar2.set(Calendar.MINUTE, 5);
//            calendar2.set(Calendar.SECOND, 0);
//
//            Calendar calendar3 = Calendar.getInstance();
//            calendar3.setTimeInMillis(System.currentTimeMillis());
//            calendar3.set(Calendar.HOUR_OF_DAY, 23);
//            calendar3.set(Calendar.MINUTE, 39);
//            calendar3.set(Calendar.SECOND, 0);
//
//            Calendar calendar4 = Calendar.getInstance();
//            calendar4.setTimeInMillis(System.currentTimeMillis());
//            calendar4.set(Calendar.HOUR_OF_DAY,23 );
//            calendar4.set(Calendar.MINUTE, 56);
//            calendar4.set(Calendar.SECOND, 0);
//
//            Calendar calendar5 = Calendar.getInstance();
//            calendar5.set(Calendar.HOUR_OF_DAY, 23);
//            calendar5.set(Calendar.MINUTE, 59);
//            calendar5.set(Calendar.SECOND, 0);
//
//            a = Calendar.getInstance().after(calendar);
//            b = Calendar.getInstance().after(calendar2);
//            c = Calendar.getInstance().after(calendar3);
//            d = Calendar.getInstance().after(calendar4);
//            e = Calendar.getInstance().after(calendar5);
//            if (a) {
//                Intent intent = new Intent(Diet_Page.this, Notification_Receiver.class);
//                PendingIntent pendingIntent = PendingIntent.getBroadcast(Diet_Page.this, 0, intent, 0);
//                AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
//                am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
//
//            }
//            else if (b) {
//                Intent intent2 = new Intent(Diet_Page.this, Notification_Receiver.class);
//                PendingIntent pendingIntent2 = PendingIntent.getBroadcast(Diet_Page.this, 0, intent2,0);
//                AlarmManager am2 = (AlarmManager) getSystemService(ALARM_SERVICE);
//                am2.setRepeating(AlarmManager.RTC_WAKEUP, calendar2.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent2);
//
//            }
//            else if (c) {
//                Intent intent3 = new Intent(Diet_Page.this, Notification_Receiver.class);
//                PendingIntent pendingIntent3 = PendingIntent.getBroadcast(Diet_Page.this, 0, intent3, PendingIntent.FLAG_UPDATE_CURRENT);
//                AlarmManager am3 = (AlarmManager) getSystemService(ALARM_SERVICE);
//                am3.setRepeating(AlarmManager.RTC_WAKEUP, calendar3.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent3);
//
//            }
//            else if (d) {
//                Intent intent4 = new Intent(Diet_Page.this, Notification_Receiver.class);
//                PendingIntent pendingIntent4 = PendingIntent.getBroadcast(Diet_Page.this, 0, intent4, PendingIntent.FLAG_UPDATE_CURRENT);
//                AlarmManager am4 = (AlarmManager) getSystemService(ALARM_SERVICE);
//                am4.setRepeating(AlarmManager.RTC_WAKEUP, calendar4.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent4);
//
//            }
//            else  {
//                Intent intent5 = new Intent(Diet_Page.this, Notification_Receiver.class);
//                PendingIntent pendingIntent5 = PendingIntent.getBroadcast(Diet_Page.this, 0, intent5, PendingIntent.FLAG_UPDATE_CURRENT);
//                AlarmManager am5 = (AlarmManager) getSystemService(ALARM_SERVICE);
//                am5.setRepeating(AlarmManager.RTC_WAKEUP, calendar5.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent5);
//
//            }


            Toast.makeText(getApplicationContext(), " Saved types ", Toast.LENGTH_SHORT).show();
            Intent intent2=new Intent(Diet_Page.this,MainActivity.class);
             startActivity(intent2);

        }

        return super.onOptionsItemSelected(item);
    }

}

