package me.objectyan.screensharing.core;

import android.os.Handler;
import android.os.Looper;


public class MsgMainHandler extends Handler  {

    private static MsgMainHandler f3628a = new MsgMainHandler();

    private MsgMainHandler() {
        super(Looper.getMainLooper());
    }


    public static MsgMainHandler m4465a() {
        return f3628a;
    }
}
