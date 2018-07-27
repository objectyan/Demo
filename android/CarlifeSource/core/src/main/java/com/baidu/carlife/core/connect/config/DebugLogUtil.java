package com.baidu.carlife.core.connect.config;

import android.content.Context;
import android.os.Message;
import android.widget.Toast;

import com.baidu.carlife.core.MsgBaseHandler;
import com.baidu.carlife.core.MsgHandlerCenter;

/* compiled from: DebugLogUtil */
/* renamed from: com.baidu.carlife.core.connect.a.c */
public class DebugLogUtil {
    /* renamed from: a */
    private static final boolean f3235a = false;
    /* renamed from: b */
    private static DebugLogUtil sDebugLogUtil = null;
    /* renamed from: c */
    private static final int f3237c = 2222222;
    /* renamed from: d */
    private static final String KEY = "key";
    /* renamed from: e */
    private Context mContext;
    /* renamed from: f */
    private DebugLogUtilHandler mDebugLogUtilHandler = new DebugLogUtilHandler(this);

    /* compiled from: DebugLogUtil */
    /* renamed from: com.baidu.carlife.core.connect.a.c$a */
    private class DebugLogUtilHandler extends MsgBaseHandler {
        /* renamed from: a */
        final /* synthetic */ DebugLogUtil mDebugLogUtil;

        private DebugLogUtilHandler(DebugLogUtil debugLogUtil) {
            this.mDebugLogUtil = debugLogUtil;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 2222222:
                    Toast.makeText(this.mDebugLogUtil.mContext, msg.getData().getString("key"), Toast.LENGTH_SHORT).show();
                    return;
                default:
                    return;
            }
        }

        public void careAbout() {
            addMsg(DebugLogUtil.f3237c);
        }
    }

    private DebugLogUtil() {
        MsgHandlerCenter.registerMessageHandler(this.mDebugLogUtilHandler);
    }

    /* renamed from: a */
    public static DebugLogUtil newInstance() {
        if (sDebugLogUtil == null) {
            sDebugLogUtil = new DebugLogUtil();
        }
        return sDebugLogUtil;
    }

    /* renamed from: a */
    public void setContext(Context context) {
        this.mContext = context;
    }

    /* renamed from: a */
    public void m4117a(String str) {
    }
}
