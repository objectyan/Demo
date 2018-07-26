package com.baidu.navisdk.util.statistic;

import android.content.Context;

public interface IBNStatisticsListener {
    void onEvent(Context context, String str, String str2);

    void onEvent(String str, String str2);

    void onEventDuration(Context context, String str, String str2, int i);

    void onEventDuration(String str, String str2, int i);

    void onEventEnd(Context context, String str, String str2);

    void onEventStart(Context context, String str, String str2);
}
