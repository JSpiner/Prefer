package net.jspiner.preferlib;

import android.app.Application;

import net.jspiner.prefer.Prefer;

/**
 * Copyright 2017 JSpiner. All rights reserved.
 *
 * @author jspiner (jspiner@naver.com)
 * @project PreferLib
 * @since 17. 2. 25
 */

public class TestApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Prefer.init(this);
    }
}
