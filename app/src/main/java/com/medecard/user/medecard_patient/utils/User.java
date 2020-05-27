package com.medecard.user.medecard_patient.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.medecard.user.medecard_patient.LoginActivity;

import static java.lang.System.out;

public class User {
    public static Gson gson = new Gson();
    public Context context;
    SharedPreferences preferences;
    public static String user;

    public User(Context context){
        this.context = context;
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        user = preferences.getString("user", "");
    }

    public String getUser() {
        return preferences.getString("user", "");
    }

    public com.medecard.user.medecard_patient.models.User getUserModel() {
        String u = preferences.getString("user", "");
        return gson.fromJson(u, com.medecard.user.medecard_patient.models.User.class);
    }

    public void storeUser(String json) {
        out.println("============================ STORED USER ============================ "+json);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user", json);
        editor.apply();
    }

    public boolean isLoggedIn() {
        return (user != "");
    }

    public void logOut() {
        SharedPreferences user = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = user.edit();
        editor.clear();
        editor.apply();
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }
}