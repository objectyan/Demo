package com.baidu.carlife.core;

import android.os.Handler;
import android.os.Looper;

/* compiled from: MsgMainHandler */
/* renamed from: com.baidu.carlife.core.l */
public class MsgMainHandler extends Handler implements KeepClass {
    /* renamed from: a */
    private static MsgMainHandler f3628a = new MsgMainHandler();

    private MsgMainHandler() {
        super(Looper.getMainLooper());
    }

    /* renamed from: a */
    public static MsgMainHandler m4465a() {
        return f3628a;
    }
}
