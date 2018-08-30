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

    public static String getArticleUrl(String article) {
        // TODO: Note for reviewer
        // Why isn't the url part of the original JSON that provided the article?
        // What if the article cam from another source that isn't Project Guternberg?
        if (article != null) {
            // I will assume the first link with http://www.gutenberg.org/ is the URL of the article.
            article = article.replaceAll("\r\n|\n", " ");
            String header = "http://www.gutenberg.org/";
            int start = article.indexOf(header);
            if (start > 0) {
                int end = article.indexOf(" ", start);
                if (end > start) {
                    String address = article.substring(start, end).trim();
                    return address;
                }
            }
        }
        return null;
    }
}
