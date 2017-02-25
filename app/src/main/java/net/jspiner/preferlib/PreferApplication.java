package net.jspiner.preferlib;

import android.app.Application;

/**
 * Copyright 2017 JSpiner. All rights reserved.
 *
 * @author jspiner (jspiner@naver.com)
 * @project PreferLib
 * @since 17. 2. 25
 */

public class PreferApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Prefer.init(getApplicationContext());

    }
}
