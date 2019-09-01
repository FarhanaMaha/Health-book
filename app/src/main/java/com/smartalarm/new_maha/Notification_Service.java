package com.smartalarm.new_maha;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.util.Calendar;

/**
 * Created by MAHA on 1/18/2019.
 */

public class Notification_Service extends IntentService{
    public NotificationManager alarmNotificationManager;
    public Notification_Service() {
        super("NotificationService");
    }
    SharedPreferences sharedPreferences;
    Intent intent;
    SharedPreferences.Editor editor;
    public String msg, title;
    boolean a,b,c,d,e;
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        sendNotification();
    }
    private void sendNotification() {
        // Equation_solve ins = new Equation_solve();
       // Log.d("AlarmService", "Preparing to send notification...: " );
        alarmNotificationManager = (NotificationManager) this
                .getSystemService(Context.NOTIFICATION_SERVICE);

        sharedPreferences=getSharedPreferences("type", Context.MODE_PRIVATE);

        String types=sharedPreferences.getString("types","");
        Calendar calendar = Calendar.getInstance();
      //  calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.AM_PM,Calendar.AM);
        calendar.set(Calendar.HOUR_OF_DAY, 6);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Calendar calendar2 = Calendar.getInstance();
        //calendar2.setTimeInMillis(System.currentTimeMillis());
        calendar2.set(Calendar.HOUR_OF_DAY, 10);
        calendar2.set(Calendar.MINUTE, 0);
        calendar2.set(Calendar.SECOND, 0);

        Calendar calendar3 = Calendar.getInstance();
     //   calendar3.setTimeInMillis(System.currentTimeMillis());
        calendar3.set(Calendar.HOUR_OF_DAY, 14);
        calendar3.set(Calendar.MINUTE, 0);
        calendar3.set(Calendar.SECOND, 0);

        Calendar calendar4 = Calendar.getInstance();
        // calendar4.setTimeInMillis(System.currentTimeMillis());
        calendar4.set(Calendar.HOUR_OF_DAY,18 );
        calendar4.set(Calendar.MINUTE, 0);
        calendar4.set(Calendar.SECOND, 0);


        Calendar calendar5 = Calendar.getInstance();
        calendar5.set(Calendar.HOUR_OF_DAY, 20);
        calendar5.set(Calendar.MINUTE, 0);
        calendar5.set(Calendar.SECOND, 0);

        a = Calendar.getInstance().after(calendar);
        b = Calendar.getInstance().after(calendar2);
        c = Calendar.getInstance().after(calendar3);
        d = Calendar.getInstance().after(calendar4);
        e = Calendar.getInstance().after(calendar5);
        switch (types){
            case "gain":
            if (a) {

                title = "Breakfast";
                msg = "Bread(2 pieces)= 136cal," +
                        "Mixed vegetables(100gm)= 45cal," +
                        "Multi-vitamin(1 piece)=0cal";

            }
            if (b) {
                title = "Mid Morning";
                msg = "Tea/coffee without milk,suger(1 cup)=0 cal," +
                        " Banana(one)=98cal";
            }
            if (c) {
                title = "Lunch";
                msg = "Rice(150gm)= 200cal" +
                        "Fish/Chicken meat(100g)=221cal," +
                        "Lentil 25g=88cal," +
                        "Spinach/green leafy vegetables(150grams)=31cal)," +
                        "Butter/ghee/olive oil/coconut oil one spoon=135cal";
            }
            if (d) {
                title = "Evining";
                msg = "apple(one)=86cal," +
                        "Tea/Coffee with milk(one cup)";
            } if (e){
                title = "Dinner";
                msg = "Rice(150gm)= 200cal" +
                        "Fish/Chicken meat(159 g)=221cal," +
                        "Lentil (25g)=88cal," +
                        "Spinach/green leafy vegetables (150grams)=31cal)," +
                        "Butter/ghee/olive oil/coconut oil one spoon=135cal";
            }
            intent = new Intent(Notification_Service.this, Add_Food.class);
                     break;
            case "maintain":
                if (a) {

                    title = "Breakfast";
                    msg = "Bread(2 pieces)= 136cal," +
                            "Mixed vegetables(100gm)= 45cal," +
                            "Multi-vitamin(1 piece)=0cal";

                } else if (b) {
                    title = "Mid Morning";
                    msg = "Tea/coffee without milk,suger(1 cup)=0 cal," +
                            " Banana(one)=98cal";
                } else if (c) {
                    title = "Lunch";
                    msg = "Rice(150gm)= 200cal" +
                            "Fish/Chicken meat(100g)=221cal," +
                            "Lentil 25g=88cal," +
                            "Spinach/green leafy vegetables(150grams)=31cal)," +
                            "Butter/ghee/olive oil/coconut oil one spoon=135cal";
                } else if (d) {
                    title = "Evining";
                    msg = "apple(one)=86cal," +
                            "Tea/Coffee with milk(one cup)";
                } if(e) {
                    title = "Dinner";
                    msg = "Rice(150gm)= 200cal" +
                            "Fish/Chicken meat(159 g)=221cal," +
                            "Lentil (25g)=88cal," +
                            "Spinach/green leafy vegetables (150grams)=31cal)," +
                            "Butter/ghee/olive oil/coconut oil one spoon=135cal";
                }
            intent = new Intent(Notification_Service.this, Add_Food.class);
           break;
            case "loss":
            if (a) {
                title = "Breakfast";
                msg = "omelette/egg pots(two)=146cal,\n" +
                        "Butter/ghee/olive oil/coconut oil(one spoon)=135cal," +
                        "Multi-Vitamin one=0cal,civet one =0cal";

            } else if (b) {
                title = "Mid Morning";
                msg = "Tropical almond(15 pieces)=105cal," +
                        " Banana(one)=98cal";
            } else if (c) {
                title = "Lunch";
                msg = "Fish/Chicken meat(159g)=221cal," +
                        "Lentil 25g=88cal," +
                        "Spinach/green leafy vegetables(150grams)=31cal)," +
                        "Butter/ghee/olive oil/coconut oil one spoon=135cal";
            } else if (d) {
                title = "Evining";
                msg = "apple(one)=86cal," + "Tea/Coffee with out milk and sugger one cup";
            } if (e){
                title = "Dinner";
                msg = "Fish/Chicken meat(159 g)=221cal," +
                        "Lentil (25g)=88cal," +
                        "Spinach/green leafy vegetables (150grams)=31cal)," +
                        "Butter/ghee/olive oil/coconut oil one spoon=135cal";
            }

                intent = new Intent(Notification_Service.this, Add_Food.class);
                break;
               default:
            intent = new Intent(Notification_Service.this, Notification_Service.class);
        }

//        switch (types){
//            case "gain":
//                title = "Breakfast";
//                msg = "Bread(2 pieces)= 136cal," +
//                        "Mixed vegetables(100gm)= 45cal," +
//                        "Multi-vitamin(1 piece)=0cal";
//                intent =  new Intent(Notification_Service.this,Add_Food.class);
//                break;
//            case "maintain":
//                title = "Evining";
//                msg = "apple(one)=86cal," +
//                        "Tea/Coffee with milk(one cup)";
//                intent =  new Intent(Notification_Service.this,Add_Food.class);
//                break;
//            case "loss":
//                title = "Lunch";
//                msg = "Fish/Chicken meat(159g)=221cal," +
//                        "Lentil 25g=88cal," +
//                        "Spinach/green leafy vegetables(150grams)=31cal)," +
//                        "Butter/ghee/olive oil/coconut oil one spoon=135cal";
//                intent =  new Intent(Notification_Service.this,Add_Food.class);
//                break;
//            default:
//                intent =  new Intent(Notification_Service.this,Notification_Service.class);
//
//        }
//        if (types.equals("gain")){
//            title = "Breakfast";
//                msg = "Bread(2 pieces)= 136cal," +
//                        "Mixed vegetables(100gm)= 45cal," +
//                        "Multi-vitamin(1 piece)=0cal";
//            intent =  new Intent(Notification_Service.this,Add_Food.class);
//
//
//        }else if (types.equals("maintain")){
//            title = "Evining";
//                msg = "apple(one)=86cal," +
//                        "Tea/Coffee with milk(one cup)";
//            intent =  new Intent(Notification_Service.this,Add_Food.class);
//
//
//        }
//        else if (types.equals("loss")){
//            title = "Lunch";
//             msg = "Fish/Chicken meat(159g)=221cal," +
//                       "Lentil 25g=88cal," +
//                      "Spinach/green leafy vegetables(150grams)=31cal)," +
//                      "Butter/ghee/olive oil/coconut oil one spoon=135cal";
//            intent =  new Intent(Notification_Service.this,Add_Food.class);
//        }
//        else {
//            intent =  new Intent(Notification_Service.this,Notification_Service.class);
//        }

        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,intent
                , PendingIntent.FLAG_UPDATE_CURRENT);


        String channelID="channelID";
        NotificationCompat.Builder alamNotificationBuilder = new NotificationCompat.Builder(
                this,channelID).setContentTitle(title).setSmallIcon(R.drawable.ic_notifications_on_white_24dp)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(msg))
                .setContentText(msg)
                .setAutoCancel(true)
               .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000});

        alamNotificationBuilder.setContentIntent(contentIntent);
        alarmNotificationManager.notify(1, alamNotificationBuilder.build());
        Log.d("AlarmService", "Notification sent.");
    }
}

//    public NotificationManager alarmNotificationManager;
//
//    public Notification_Service() {
//        super("Notification_Service");
//    }
//
//    SharedPreferences sharedPreferences;
//
//    SharedPreferences.Editor editor;
//    public String msg, title;
//    boolean a, b, c, d, e;
//    Intent intent;
//
//    @Override
//    protected void onHandleIntent(@Nullable Intent intent) {
//
//        alarmNotificationManager = (NotificationManager) this
//                .getSystemService(Context.NOTIFICATION_SERVICE);
//        sharedPreferences = getSharedPreferences("type", Context.MODE_PRIVATE);
//        String type = sharedPreferences.getString("gain_types", "");
////        Calendar calendar = Calendar.getInstance();
////        calendar.set(Calendar.HOUR_OF_DAY, 8);
////        calendar.set(Calendar.MINUTE, 30);
////        calendar.set(Calendar.SECOND, 0);
////
////        Calendar calendar2 = Calendar.getInstance();
////        calendar2.setTimeInMillis(System.currentTimeMillis());
////        calendar2.set(Calendar.HOUR_OF_DAY, 20);
////        calendar2.set(Calendar.MINUTE, 25);
////        calendar2.set(Calendar.SECOND, 0);
////
////        Calendar calendar3 = Calendar.getInstance();
////        calendar3.setTimeInMillis(System.currentTimeMillis());
////        calendar3.set(Calendar.HOUR_OF_DAY, 20);
////        calendar3.set(Calendar.MINUTE, 29);
////        calendar3.set(Calendar.SECOND, 0);
////
////        Calendar calendar4 = Calendar.getInstance();
////         calendar4.setTimeInMillis(System.currentTimeMillis());
////        calendar4.set(Calendar.HOUR_OF_DAY,7 );
////        calendar4.set(Calendar.MINUTE, 56);
////        calendar4.set(Calendar.SECOND, 0);
////
////
////        Calendar calendar5 = Calendar.getInstance();
////        calendar5.set(Calendar.HOUR_OF_DAY, 2);
////        calendar5.set(Calendar.MINUTE, 59);
////        calendar5.set(Calendar.SECOND, 0);
////
////        a = Calendar.getInstance().after(calendar);
////        b = Calendar.getInstance().after(calendar2);
////        c = Calendar.getInstance().after(calendar3);
////        d = Calendar.getInstance().after(calendar4);
////        e = Calendar.getInstance().after(calendar5);
//        if (type.equals("gain")) {
////            if (a) {
//                title = "Breakfast";
//                msg = "Bread(2 pieces)= 136cal," +
//                        "Mixed vegetables(100gm)= 45cal," +
//                        "Multi-vitamin(1 piece)=0cal";
////
////            } else if (b) {
////                title = "Mid Morning";
////                msg = "Tea/coffee without milk,suger(1 cup)=0 cal," +
////                        " Banana(one)=98cal";
////            } else if (c) {
////                title = "Lunch";
////                msg = "Rice(150gm)= 200cal" +
////                        "Fish/Chicken meat(100g)=221cal," +
////                        "Lentil 25g=88cal," +
////                        "Spinach/green leafy vegetables(150grams)=31cal)," +
////                        "Butter/ghee/olive oil/coconut oil one spoon=135cal";
////            } else if (d) {
////                title = "Evining";
////                msg = "apple(one)=86cal," +
////                        "Tea/Coffee with milk(one cup)";
////            } else {
////                title = "Dinner";
////                msg = "Rice(150gm)= 200cal" +
////                        "Fish/Chicken meat(159 g)=221cal," +
////                        "Lentil (25g)=88cal," +
////                        "Spinach/green leafy vegetables (150grams)=31cal)," +
////                        "Butter/ghee/olive oil/coconut oil one spoon=135cal";
//     //       }
//            intent = new Intent(Notification_Service.this, Add_Food.class);
//
//        } else if (type.equals("maintain")) {
////            if (a) {
//                title = "Breakfast";
//                msg = "omelette/egg pots(two)=146cal,\n" +
//                        "Butter/ghee/olive oil/coconut oil(one spoon)=135cal," +
//                        "Multi-Vitamin one=0cal,civet one =0cal";
////
////            } else if (b) {
////                title = "Mid Morning";
////                msg = "Tropical almond(15 pieces)=105cal," +
////                        " Banana(one)=98cal";
////            } else if (c) {
////                title = "Lunch";
////                msg = "Fish/Chicken meat(159g)=221cal," +
////                        "Lentil 25g=88cal," +
////                        "Spinach/green leafy vegetables(150grams)=31cal)," +
////                        "Butter/ghee/olive oil/coconut oil one spoon=135cal";
////            } else if (d) {
////                title = "Evining";
////                msg = "apple(one)=86cal," +
////                        "Tea/Coffee with out milk and sugger one cup";
////            } else {
////                title = "Dinner";
////                msg = "Fish/Chicken meat(159 g)=221cal," +
////                        "Lentil (25g)=88cal," +
////                        "Spinach/green leafy vegetables (150grams)=31cal)," +
////                        "Butter/ghee/olive oil/coconut oil one spoon=135cal";
////            }
//            intent = new Intent(Notification_Service.this, Add_Food.class);
//
//        } else if (type.equals("loss")) {
////            if (a) {
////                title = "Breakfast";
////                msg = "omelette/egg pots(two)=146cal,\n" +
////                        "Butter/ghee/olive oil/coconut oil(one spoon)=135cal," +
////                        "Multi-Vitamin one=0cal,civet one =0cal";
////
////            } else if (b) {
////                title = "Mid Morning";
////                msg = "Tropical almond(15 pieces)=105cal," +
////                        " Banana(one)=98cal";
////            } else if (c) {
////                title = "Lunch";
////                msg = "Fish/Chicken meat(159g)=221cal," +
////                        "Lentil 25g=88cal," +
////                        "Spinach/green leafy vegetables(150grams)=31cal)," +
////                        "Butter/ghee/olive oil/coconut oil one spoon=135cal";
////            } else if (d) {
//                title = "Evining";
//                msg = "apple(one)=86cal," + "Tea/Coffee with out milk and sugger one cup";
////            } else {
////                title = "Dinner";
////                msg = "Fish/Chicken meat(159 g)=221cal," +
////                        "Lentil (25g)=88cal," +
////                        "Spinach/green leafy vegetables (150grams)=31cal)," +
////                        "Butter/ghee/olive oil/coconut oil one spoon=135cal";
////            }
////            intent = new Intent(Notification_Service.this, Add_Food.class);
////
////            title = "Lunch";
////            msg = "Fish/Chicken meat(159g)=221cal," +
////                    "Lentil 25g=88cal," +
////                    "Spinach/green leafy vegetables(150grams)=31cal)," +
////                    "Butter/ghee/olive oil/coconut oil one spoon=135cal";
//       } else {
//            intent = new Intent(Notification_Service.this, Notification_Service.class);
//        }
//
//
//       // intent=new Intent(getApplicationContext(),Notification_Receiver.class);
//
//             PendingIntent contentIntent = PendingIntent.getActivity(this, 0,intent
//            , 0);
//    //    PendingIntent contentIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//        String channelID = "channelID";
//        NotificationCompat.Builder alamNotificationBuilder = new NotificationCompat.Builder(
//                this, channelID).setContentTitle(title).setSmallIcon(R.drawable.ic_notifications_on_white_24dp)
//                .setStyle(new NotificationCompat.BigTextStyle().bigText(msg))
//                .setContentText(msg)
//                .setAutoCancel(true)
//                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000});
//
//
//        alamNotificationBuilder.setContentIntent(contentIntent);
//        alarmNotificationManager.notify(0, alamNotificationBuilder.build());
//
//    }
//}
//
//
