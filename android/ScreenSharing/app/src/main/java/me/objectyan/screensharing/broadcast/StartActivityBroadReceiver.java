package com.baidu.carlife.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.platform.C1984a;

public class StartActivityBroadReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (TextUtils.equals("com.baidu.carlife.Action.StartActivityBroadReceiver", action)) {
            Intent i = new Intent(C1984a.f6383b);
            i.setFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
            context.startActivity(i);
            return;
        }
        Intent mainIntent = new Intent(context, CarlifeActivity.class);
        mainIntent.setFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
        mainIntent.setAction(action);
        context.startActivity(mainIntent);
    }
}
