
Prefer ![img](https://travis-ci.org/JSpiner/Prefer.svg?branch=master)
============
Prefer is android advanced sharedpreference library.

Supporting `Integer`, `String`, `Float`, `Long`, `Boolean`.

Functions
------------
init prefer class with context 
```java
public static void init(@NonNull Context context);

public static void init(@NonNull Context context, @NonNull String fileName);
```

you can get sharedpreference object
```java
public static synchronized SharedPreferences getSharedPreferences();
```

set/get `key-value` pair
```java
public static void set(@NonNull String key, @NonNull Object value);

public static <T> T get(@NonNull String key, @NonNull T defaultValue);
```

Init Prefer
----------
init prefer `AppApplication.java`
```java
class AppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
		
		Prefer.init(this);
    }
}
```

add application in `AndroidManifest.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="net.jspiner.preferlib">

    <application
        android:allowBackup="true"
        android:name=".AppApplication" <-- this line
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>

    </application>

</manifest>
```

Set value
--------
Prefer automatically check the type of this and save it.
It's very simple.

Before you know Prefer
```java
    void setDataUsingSharedPreference(){

        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editor;

        sharedPreferences = getBaseContext().getSharedPreferences("data", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        editor.putInt("int1", 1);
        editor.putInt("int2", 2);
        editor.putString("string1", "hello1");
        editor.putBoolean("boolean", true);
        editor.putFloat("float1", 1.3f);

        editor.commit();
        // very complex...
    }
```


After you know Prefer
```java
    void setDataUsingPrefer(){

        Prefer.set("int1", 1);
        Prefer.set("int2", 2);
        Prefer.set("string1", "hello1");
        Prefer.set("boolean", true);
        Prefer.set("float1", 1.3f);
        // awesome! very simple!

    }
```


Get Value
---------------
Using default value, the type is automatically checked and loaded.

Before you know Prefer
```java
    void getDataUsingSharedPreference(){

        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editor;

        sharedPreferences = getBaseContext().getSharedPreferences("data", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        int int1 = sharedPreferences.getInt("int1", 0);
        int int2 = sharedPreferences.getInt("int2", 2);
        String string1 = sharedPreferences.getString("string1", "none");
        Boolean boolean1 = sharedPreferences.getBoolean("boolean", true);
        Float float1 = sharedPreferences.getFloat("float1", 0f);
        // too many functions.... very very complex
        
    }
```

After you know Prefer
```java
    void getDataUsingPrefer(){

        int int1 = Prefer.get("int1", 0);
        int int2 = Prefer.get("int2", 0);
        String string1 = Prefer.get("string1", "none");
        Boolean boolean1 = Prefer.get("boolean1", true);
        Float float1 = Prefer.get("float1", 0f);
        
        // Automatically cast everything to as single function!!
        // Amaaaaaazing!
    }
```
