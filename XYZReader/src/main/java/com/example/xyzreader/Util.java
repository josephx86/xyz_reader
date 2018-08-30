package com.example.xyzreader;


import android.content.Context;
import android.graphics.Typeface;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Util {
    private static Typeface typeface;

    public static SimpleDateFormat getSimpleDateFormat(String pattern) {
        if (pattern == null) {
            pattern = "";
        }
        return new SimpleDateFormat(pattern, Locale.getDefault());
    }

    public static GregorianCalendar getStartOfEpoch() {
        // Most time functions can only handle 1902 - 2037
        return new GregorianCalendar(2, 1, 1);
    }

    public static Typeface getCachedTypeFace(Context context) {
        // Since the same typeface is used, load it once and cache it for quick use.
        if (typeface == null) {
            typeface = Typeface.createFromAsset(context.getResources().getAssets(), "Rosario-Regular.ttf");
        }
        return typeface;
    }
}
