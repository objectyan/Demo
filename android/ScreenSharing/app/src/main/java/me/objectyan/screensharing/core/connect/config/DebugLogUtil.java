package me.objectyan.screensharing.core.connect.config;

import android.content.Context;
import android.os.Message;
import android.widget.Toast;

import me.objectyan.screensharing.core.MsgBaseHandler;
import me.objectyan.screensharing.core.MsgHandlerCenter;


public class DebugLogUtil {

    private static final boolean f3235a = false;

    private static DebugLogUtil sDebugLogUtil = null;

    private static final int f3237c = 2222222;

    private static final String KEY = "key";

    private Context mContext;

    private DebugLogUtilHandler mDebugLogUtilHandler = new DebugLogUtilHandler(this);


    private class DebugLogUtilHandler extends MsgBaseHandler {

        final DebugLogUtil mDebugLogUtil;

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


    public static DebugLogUtil newInstance() {
        if (sDebugLogUtil == null) {
            sDebugLogUtil = new DebugLogUtil();
        }
        return sDebugLogUtil;
    }


    public void setContext(Context context) {
        this.mContext = context;
    }


    public void m4117a(String str) {
    }
}
