package com.example.saurabhpandey.notifyme;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.view.View;


public class MainActivity extends Activity {
    private static final int uniqueID = 123654;
    NotificationCompat.Builder notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//Introduce Notification
        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(false);


    }


    public void notifyMe(View view) {

//Build The Notification
        notification.setSmallIcon(R.drawable.ic_launcher);
        notification.setTicker("New Word Update");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("Congrats !!!");
        notification.setContentText("Learn More and More words Daily");
//        notification.setOngoing(true); for uncancellable notification


        notification.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
        notification.setLights(Color.GREEN, 3000, 3000);
        notification.setVibrate(new long[]{1000, 1000, 1000, 1000, 1000});


        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        //Send the Notification in android Phone

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(uniqueID, notification.build());

    }
}