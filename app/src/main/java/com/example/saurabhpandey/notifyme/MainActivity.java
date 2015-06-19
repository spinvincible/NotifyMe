package com.example.saurabhpandey.notifyme;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
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
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        MainActivity.super.onBackPressed();
                    }
                }).create().show();}

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
// Add shortcut to home screen
//    private void ShortcutIcon(){
//
//        Intent shortcutIntent = new Intent(getApplicationContext(), SplashScreen.class);
//        shortcutIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        shortcutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//        Intent addIntent = new Intent();
//        addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
//        addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "NotifyMe");
//        addIntent.putExtra("duplicate", false);
//        addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(getApplicationContext(), R.drawable.ic_launcher));
//        addIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
//        getApplicationContext().sendBroadcast(addIntent);
//    }

    // Creates shortcut on Android widget screen
//    private void addShortcut() {
//        //Adding shortcut for MainActivity
//        //on Home screen
//        Intent shortcutIntent = new Intent(getApplicationContext(),
//                MainActivity.class);
//
//        shortcutIntent.setAction(Intent.ACTION_MAIN);
//
//        Intent addIntent = new Intent();
//        addIntent
//                .putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
//        addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "HelloWorldShortcut");
//        addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,
//                Intent.ShortcutIconResource.fromContext(getApplicationContext(),
//                        R.drawable.ic_launcher));
//
//        addIntent
//                .setAction("com.android.launcher.action.INSTALL_SHORTCUT");
//        getApplicationContext().sendBroadcast(addIntent);
//    }
}
