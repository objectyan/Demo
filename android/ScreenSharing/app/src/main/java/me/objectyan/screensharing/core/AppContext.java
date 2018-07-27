package me.objectyan.screensharing.core;

import android.content.Context;
import android.content.ContextWrapper;


public class AppContext extends ContextWrapper  {

    private static AppContext sAppContext;


    public static AppContext getAppContext() {
        return sAppContext;
    }

    private AppContext(Context ctx) {
        super(ctx);
    }


    public static synchronized void newInstance(Context context) {
        synchronized (AppContext.class) {
            if (sAppContext == null) {
                sAppContext = new AppContext(context);
            }
        }
    }
}
