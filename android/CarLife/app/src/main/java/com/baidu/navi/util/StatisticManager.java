package com.baidu.navi.util;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.mobstat.StatService;
import com.baidu.navisdk.BNaviModuleManager;
import java.util.LinkedHashMap;

public class StatisticManager {
    public static LinkedHashMap<View, String> mLRUCache = new LinkedHashMap(50);

    public static void setAppChannel(String channel) {
        StatService.setAppChannel(channel);
    }

    public static void setDebugOn() {
        StatService.setDebugOn(true);
    }

    public static void onFragmentResume(Fragment fragment) {
        StatService.onResume(fragment);
    }

    public static void onFragmentPause(Fragment fragment) {
        StatService.onPause(fragment);
    }

    public static void onActivityResume(Context context) {
        StatService.onResume(context);
    }

    public static void onActivityPause(Context context) {
        StatService.onPause(context);
    }

    public static void onPageStart(Context context, String pageName) {
        StatService.onPageStart(context, pageName);
    }

    public static void onPageEnd(Context context, String pageName) {
        StatService.onPageEnd(context, pageName);
    }

    public static void onEvent(String eventId) {
        StatService.onEvent(BNaviModuleManager.getContext(), eventId, eventId);
        C1260i.b("mtj", "eventId: " + eventId + " label: " + eventId);
    }

    public static void onEvent(String eventId, String label) {
        StatService.onEvent(C1157a.a(), eventId, label);
        C1260i.b("mtj", "eventId: " + eventId + " label: " + label);
    }

    public static void onEvent(Activity activity, View view) {
        String eventId = (String) mLRUCache.get(view);
        if (eventId == null) {
            String pageName = getPageName(activity);
            CharSequence descName = null;
            if (view instanceof Button) {
                descName = ((Button) view).getText();
            } else if (view instanceof ImageView) {
                descName = ((ImageView) view).getContentDescription();
            } else {
                TextView tv = traversalTextView(view);
                if (tv != null) {
                    descName = tv.getText();
                }
            }
            if (descName == null || descName.length() == 0) {
                StackTraceElement ste = new Throwable().getStackTrace()[1];
                pageName = ste.getFileName();
                descName = "line:" + ste.getLineNumber();
            }
            eventId = pageName + "-" + descName;
            mLRUCache.put(view, eventId);
        }
        StatService.onEvent(activity, eventId, eventId);
    }

    public static void onEventStart(Context context, String eventId, String label) {
        StatService.onEventStart(context, eventId, label);
    }

    public static void onEventEnd(Context context, String eventId, String label) {
        StatService.onEventEnd(context, eventId, label);
    }

    public static void onEventDuration(Context context, String eventId, String label, int milliseconds) {
        if (milliseconds > 0) {
            StatService.onEventDuration(context, eventId, label, (long) (milliseconds / 2));
            C1260i.b("mtj", "eventId: " + eventId + " label: " + label + " duration: " + (milliseconds / 2));
        }
    }

    public static void onEventMileage(Context context, String eventId, String label, int meter) {
        if (meter > 0) {
            StatService.onEventDuration(context, eventId, label, (long) (meter * 10));
            C1260i.b("mtj", "eventId: " + eventId + " label: " + label + " duration: " + (meter * 10));
        }
    }

    private static TextView traversalTextView(View view) {
        if (view instanceof TextView) {
            return (TextView) view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup vg = (ViewGroup) view;
        for (int i = 0; i < vg.getChildCount(); i++) {
            View tv = traversalTextView(vg.getChildAt(i));
            if (tv != null) {
                return tv;
            }
        }
        return null;
    }

    private static String getPageName(Activity activity) {
        String pageName = activity.getClass().getSimpleName();
        if (!(activity instanceof CarlifeActivity)) {
            return pageName;
        }
        Fragment fragment = C1328h.a().getCurrentFragment();
        if (fragment != null) {
            return fragment.getClass().getSimpleName();
        }
        return pageName;
    }
}
