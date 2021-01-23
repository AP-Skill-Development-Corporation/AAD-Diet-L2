package com.example.examplework;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class ThirdWork extends Worker {
    NotificationManager nm;
    public ThirdWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        nm= (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    @NonNull
    @Override
    public Result doWork() {
       createNotification();
       sendNotification();
        return Result.success();
    }

    private void sendNotification() {
        NotificationCompat.Builder builder=new NotificationCompat
                .Builder(getApplicationContext(),"DIET");
        Intent i=new Intent(getApplicationContext(),MainActivity.class);
        PendingIntent pi= PendingIntent.getActivity(getApplicationContext()
                ,1,i,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentTitle("Notify");
        builder.setContentText("This is a notification");
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setContentIntent(pi);
        nm.notify(0,builder.build());
    }

    private void createNotification() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel nc=new NotificationChannel("DIET","Notify",
                    NotificationManager.IMPORTANCE_HIGH);
            nc.enableLights(true);
            nc.enableVibration(true);
            nm.createNotificationChannel(nc);
        }
    }
}
