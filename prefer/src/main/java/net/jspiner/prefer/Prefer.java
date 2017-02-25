package net.jspiner.prefer;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.util.Log;

/**
 * Copyright 2017 JSpiner. All rights reserved.
 *
 * @author jspiner (jspiner@naver.com)
 * @project PreferLib
 * @since 17. 2. 25
 */

/**
 * 'Prefer' is an advanced android sharedpreference library.
 *
 * Example
 *
 * Prefer.set("user_int_state", 1);
 * int userState = Prefer.get("user_int_state", 0);
 *
 * Prefer.set("user_name", "john smith");
 * String userName = Prefer.get("user_name", "none");
 *
 * Prefer.set("enable_push_noti", true);
 * Boolean pushEnable = Prefer.get("enable_push_noti", false);
 *
 * It support String, Integer, Float, Boolean, Long, Structure(soon....)
 */

public class Prefer {

    // logging tag
    private static final String TAG = Prefer.class.getSimpleName();

    private static SharedPreferences preferences;
    private static String fileName;

    private static Context context;

    /*
    *   Basic Constructor
    *
    *   set default context and sharedpreferece file name.
    *   
    * */

    public static void init(@NonNull Context context){
        Prefer.context = context;
        Prefer.fileName = context.getPackageName();
    }

    public static void init(@NonNull Context context, @NonNull String fileName){
        Prefer.context = context;
        Prefer.fileName = fileName;
    }

    public static synchronized SharedPreferences getSharedPreferences(){
        if(context == null){
            throw new NullPointerException();
        }

        if(preferences == null){
            preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        }
        return preferences;
    }

    public static void set(@NonNull String key, @NonNull Object value){
        if(key==null || value==null){
            throw new NullPointerException();
        }

        SharedPreferences.Editor editor = getSharedPreferences().edit();

        if(value instanceof Integer){
            Log.d(TAG, "set integer value");
            editor.putInt(key, (int)value);
        }
        else if(value instanceof String){
            Log.d(TAG, "string");
            editor.putString(key, (String)value);
        }
        else if(value instanceof Boolean){
            Log.d(TAG, "boolean");
            editor.putBoolean(key, (Boolean)value);
        }
        else if(value instanceof Float){
            Log.d(TAG, "float");
            editor.putFloat(key, (Float)value);
        }
        else if(value instanceof Long){
            Log.d(TAG, "long");
            editor.putLong(key, (Long)value);
        }
        else{
            Log.d(TAG, "unknown");
            //editor.putString(key, new Gson().toJson(value));
        }

        editor.commit();
    }

    public static <T> T get(@NonNull String key, @NonNull T defaultValue){
        if (key == null){
            throw new NullPointerException();
        }

        SharedPreferences preference = getSharedPreferences();

        Class classType = defaultValue.getClass();

        Object returnValue = null;
        if(defaultValue instanceof Integer){
            Log.d(TAG, "integer");
            returnValue = preference.getInt(key, ((Integer) defaultValue).intValue());
        }
        else if(defaultValue instanceof String){
            Log.d(TAG, "string");
            returnValue = preference.getString(key, ((String)defaultValue));
        }
        else if(defaultValue instanceof Boolean){
            Log.d(TAG, "boolean");
            returnValue = preference.getBoolean(key, (Boolean)defaultValue);
        }
        else if(defaultValue instanceof Float){
            Log.d(TAG, "float");
            returnValue = preference.getFloat(key, (Float)defaultValue);
        }
        else if(defaultValue instanceof Long){
            Log.d(TAG, "long");
            returnValue = preference.getLong(key, (Long)defaultValue);
        }
        else{
            Log.d(TAG, "unknown");
            returnValue = preference.getString(key, (String)defaultValue);
        }

        return (T)classType.cast(returnValue);


    }

}
