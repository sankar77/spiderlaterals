package com.example.dell.exampleappwidgetprovider;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RemoteViews;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
//import android.support.design.widget.Snackbar;

import java.util.Random;

public class ExampleAppWidgetProvider extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        {
            final int N = appWidgetIds.length;

            // Perform this loop procedure for each App Widget that belongs to this provider
            for (int i = 0; i < N; i++) {
                int appWidgetId = appWidgetIds[i];


                // Create an Intent to launch ExampleActivity
                Intent intent = new Intent(context, he.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

                // Get the layout for the App Widget and attach an on-click listener
                // to the button
                RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.example_appwidget_info);
                views.setOnClickPendingIntent(R.id.button, pendingIntent);

                // Tell the AppWidgetManager to perform an update on the current app widget
                appWidgetManager.updateAppWidget(appWidgetId, views);

            }
        }
    }
}