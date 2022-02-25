package com.example.services;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.NotificationCompat;

public class MyService extends Service {
    final String LOG_TAG = "Log";
    NotificationManager notifManger;
    private static final int NOTIFICATION_ID=1;
    private static final String CHANNEL_ID = "100";
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(LOG_TAG, "onBind");
        return new Binder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(LOG_TAG, "onCreate");
        notifManger = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = createForegroundNotification();
        startForeground(NOTIFICATION_ID, notification);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(LOG_TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    public boolean onUnbind(Intent intent) {
        Log.d(LOG_TAG, "onUnbind");
        return super.onUnbind(intent);
    }
    private Notification createForegroundNotification() {
        createNotificationChannel(notifManger);
        Intent resultIntent2 = new Intent(this, MainActivity2.class);
        PendingIntent intent2 = PendingIntent.getActivity(this, 0, resultIntent2, 0);

        Intent resultIntent3 = new Intent(this, MainActivity3.class);
        PendingIntent intent3 = PendingIntent.getActivity(this, 0, resultIntent3, 0);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setWhen(System.currentTimeMillis())
                .setContentTitle("Сервис")
                .setContentText("Выбор активнотсти")
                .addAction(R.mipmap.ic_launcher, "1", intent2)
                .addAction(R.mipmap.ic_launcher_round, "2", intent3)
                .build();
        return notification;
    }
    private void createNotificationChannel(NotificationManager manager){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_ID, NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(notificationChannel);
        }
    }
}