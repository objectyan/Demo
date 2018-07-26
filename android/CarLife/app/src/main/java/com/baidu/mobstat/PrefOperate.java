package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;

public class PrefOperate {
    public static void loadMetaDataConfig(Context context) {
        SendStrategyEnum sendStrategyEnum = SendStrategyEnum.APP_START;
        try {
            CharSequence a = de.m15678a(context, Config.EXCEPTION_LOG_META_NAME);
            if (!TextUtils.isEmpty(a) && "true".equals(a)) {
                bt.m15504a().m15505a(context, false);
            }
        } catch (Throwable e) {
            db.m15659a(e);
        }
        try {
            String a2 = de.m15678a(context, Config.SEND_STRATEGY_META_NAME);
            if (!TextUtils.isEmpty(a2)) {
                if (a2.equals(SendStrategyEnum.APP_START.name())) {
                    sendStrategyEnum = SendStrategyEnum.APP_START;
                    bj.m15464a().m15466a(context, sendStrategyEnum.ordinal());
                } else if (a2.equals(SendStrategyEnum.ONCE_A_DAY.name())) {
                    sendStrategyEnum = SendStrategyEnum.ONCE_A_DAY;
                    bj.m15464a().m15466a(context, sendStrategyEnum.ordinal());
                    bj.m15464a().m15470b(context, 24);
                } else if (a2.equals(SendStrategyEnum.SET_TIME_INTERVAL.name())) {
                    sendStrategyEnum = SendStrategyEnum.SET_TIME_INTERVAL;
                    bj.m15464a().m15466a(context, sendStrategyEnum.ordinal());
                }
            }
        } catch (Throwable e2) {
            Throwable th = e2;
            SendStrategyEnum sendStrategyEnum2 = sendStrategyEnum;
            db.m15659a(th);
            sendStrategyEnum = sendStrategyEnum2;
        }
        try {
            Object a3 = de.m15678a(context, Config.TIME_INTERVAL_META_NAME);
            if (!TextUtils.isEmpty(a3)) {
                int parseInt = Integer.parseInt(a3);
                if (sendStrategyEnum.ordinal() == SendStrategyEnum.SET_TIME_INTERVAL.ordinal() && parseInt > 0 && parseInt <= 24) {
                    bj.m15464a().m15470b(context, parseInt);
                }
            }
        } catch (Throwable e3) {
            db.m15659a(e3);
        }
        try {
            CharSequence a4 = de.m15678a(context, Config.ONLY_WIFI_META_NAME);
            if (!TextUtils.isEmpty(a4)) {
                if ("true".equals(a4)) {
                    bj.m15464a().m15468a(context, true);
                } else if ("false".equals(a4)) {
                    bj.m15464a().m15468a(context, false);
                }
            }
        } catch (Throwable e32) {
            db.m15659a(e32);
        }
    }

    public static void setAppKey(String str) {
        CooperService.m15264a().getHeadObject().f19507f = str;
    }

    public static String getAppKey(Context context) {
        return CooperService.m15264a().getAppKey(context);
    }

    public static void setAppChannel(String str) {
        if (str == null || str.equals("")) {
            db.m15663c("设置的渠道不能为空或者为null || The channel that you have been set is null or empty, please check it.");
        }
        CooperService.m15264a().getHeadObject().f19514m = str;
    }

    public static void setAppChannel(Context context, String str, boolean z) {
        if (str == null || str.equals("")) {
            db.m15663c("设置的渠道不能为空或者为null || The channel that you have been set is null or empty, please check it.");
        }
        CooperService.m15264a().getHeadObject().f19514m = str;
        if (!(!z || str == null || str.equals(""))) {
            bj.m15464a().m15474c(context, str);
            bj.m15464a().m15472b(context, true);
        }
        if (!z) {
            bj.m15464a().m15474c(context, "");
            bj.m15464a().m15472b(context, false);
        }
    }
}
