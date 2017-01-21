package com.betterclever.aparoksha;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Pranjal Paliwal on 12/21/2016.
 */


public class Aparoksha extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
		FirebaseDatabase.getInstance().setPersistenceEnabled(true);
	}
}
