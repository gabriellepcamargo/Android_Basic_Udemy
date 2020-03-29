package com.example.festafimdeano.data;

import android.content.Context;
import android.content.SharedPreferences;

public class SecurityPreferences {

    private SharedPreferences mSharedPreference;

    public SecurityPreferences(Context mContext){
     //construtor
     this.mSharedPreference = mContext.getSharedPreferences("FestaFimAno", Context.MODE_PRIVATE);
    }
    public void storeString(String key, String value){
        this.mSharedPreference.edit().putString(key, value).apply();
    }
    public String getStoreString(String key){
        return this.mSharedPreference.getString(key, "");

    }
}
