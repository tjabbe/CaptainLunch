package com.example.martin.captainlunch;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Martin on 13/12/2016.
 */

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // init Calligraphy for easier fonts management
        CalligraphyConfig.initDefault(
                new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/geomanist-regular.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );
    }
}