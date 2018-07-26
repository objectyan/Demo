package com.baidu.navi.track.datashop;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.C1260i;
import com.baidu.navi.track.common.TrackConfig;
import com.baidu.navi.track.database.DataCache;
import com.baidu.navi.track.database.DataService;
import com.baidu.navi.track.database.DataService.Action;
import com.baidu.navi.track.model.TrackAcmp;
import com.baidu.navi.track.model.TrackDBEvent;
import com.baidu.navi.util.NaviAccountUtils;

public class TrackStatisticShop {
    private static final String TAG = TrackStatisticShop.class.getSimpleName();
    private Handler mHandler = new C39721();
    private Handler requestHandler;

    /* renamed from: com.baidu.navi.track.datashop.TrackStatisticShop$1 */
    class C39721 extends Handler {
        C39721() {
        }

        public void handleMessage(Message msg) {
            C1260i.b(TrackStatisticShop.TAG, "handleMessage msg = " + msg);
            if (msg.what == 5) {
                TrackDBEvent dbEvent = null;
                if (msg.obj instanceof TrackDBEvent) {
                    dbEvent = msg.obj;
                }
                if (dbEvent != null) {
                    C1260i.b(TrackStatisticShop.TAG, dbEvent.toString());
                    if (dbEvent.type == 5) {
                        TrackShopEvent shopEvent = new TrackShopEvent();
                        shopEvent.type = 5;
                        if (dbEvent.statistic != null) {
                            shopEvent.status = 0;
                            shopEvent.statistic = dbEvent.statistic;
                        } else {
                            shopEvent.status = -2;
                        }
                        TrackStatisticShop.this.postShopEvent(shopEvent);
                    }
                }
            }
        }
    }

    public TrackStatisticShop(Handler handler) {
        this.requestHandler = handler;
    }

    public void fetchStatistic(int monthLimit) {
        if (!NaviAccountUtils.getInstance().isLogin() || !hasCacheStatistic()) {
            fetchStatisticFromDb(monthLimit);
        }
    }

    private void fetchStatisticFromDb(int monthLimit) {
        Context context = C1157a.a();
        String bduid = NavMapAdapter.getInstance().getUid();
        Intent intent = new Intent(context, DataService.class);
        intent.putExtra(DataService.EXTRA_BDUID, bduid);
        intent.putExtra(DataService.EXTRA_LIMIT, monthLimit);
        intent.putExtra(DataService.EXTRA_HANDLER, DataCache.getInstance().addCache(this.mHandler));
        intent.setAction(Action.ACTION_GET_TRACK_STATISTICS.toString());
        context.startService(intent);
    }

    private boolean hasCacheStatistic() {
        int totalDistanse = TrackConfig.getInstance().getTotalDistanse();
        int maxTime = TrackConfig.getInstance().getMaxTime();
        int weekDistanse = TrackConfig.getInstance().getWeekDistanse();
        if (totalDistanse <= 0 || maxTime <= 0) {
            return false;
        }
        TrackAcmp model = new TrackAcmp();
        model.setCarNaviDistance(totalDistanse);
        model.setCarWeekMileage(weekDistanse);
        model.setCarMaxDuration(maxTime);
        TrackShopEvent shopEvent = new TrackShopEvent();
        shopEvent.type = 5;
        shopEvent.status = 0;
        shopEvent.statistic = model;
        postShopEvent(shopEvent);
        return true;
    }

    private void postShopEvent(TrackShopEvent event) {
        C1260i.b(TAG, event.toString());
        C1260i.b(TAG, event.statistic.toString());
        if (this.requestHandler != null) {
            this.requestHandler.obtainMessage(5, event).sendToTarget();
        }
    }
}
