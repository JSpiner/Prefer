package net.jspiner.preferlib;

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
    }
}
