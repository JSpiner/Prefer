package net.jspiner.preferlib;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.jspiner.prefer.Prefer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Prefer.init(getApplicationContext());
        Prefer.set("Dd","dd");

        setDataUsingSharedPreference();
        setDataUsingPrefer();
        getDataUsingSharedPreference();
        getDataUsingPrefer();
    }

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

    void setDataUsingPrefer(){

        Prefer.set("int1", 1);
        Prefer.set("int2", 2);
        Prefer.set("string1", "hello1");
        Prefer.set("boolean", true);
        Prefer.set("float1", 1.3f);
        // awesome! very simple!

    }

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

    void getDataUsingPrefer(){

        int int1 = Prefer.get("int1", 0);
        int int2 = Prefer.get("int2", 0);
        String string1 = Prefer.get("string1", "none");
        Boolean boolean1 = Prefer.get("boolean1", true);
        Float float1 = Prefer.get("float1", 0f);
        // Automatically cast everything to as single function!!
        // Amaaaaaazing!

    }
}
