package com.betterclever.aparoksha;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.sylversky.fontreplacer.FontReplacer;
import com.sylversky.fontreplacer.Replacer;

/**
 * Created by Pranjal Paliwal on 12/21/2016.
 */


public class Aparoksha extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
		FirebaseDatabase.getInstance().setPersistenceEnabled(true);
		
		FirebaseMessaging.getInstance().subscribeToTopic("everything");
		
		Replacer replacer = FontReplacer.Build(getApplicationContext());
		replacer.setDefaultFont("Comfortaa-Regular.ttf");
		replacer.setBoldFont("Comfortaa-Bold.ttf");
		replacer.setLightFont("Comfortaa-Light.ttf");
		
		replacer.applyFont();
		
	}
}
