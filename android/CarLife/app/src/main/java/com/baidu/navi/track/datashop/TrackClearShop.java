package com.baidu.navi.track.datashop;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.C1260i;
import com.baidu.navi.track.database.DataCache;
import com.baidu.navi.track.database.DataService;
import com.baidu.navi.track.database.DataService.Action;
import com.baidu.navi.track.model.TrackDBEvent;

public class TrackClearShop {
    private static final String TAG = "TrackClearShop";
    private Handler mHandler = new C39681();
    private String useId;

    /* renamed from: com.baidu.navi.track.datashop.TrackClearShop$1 */
    class C39681 extends Handler {
        C39681() {
        }

        public void handleMessage(Message msg) {
            if (msg.what == 4) {
                C1260i.b(TrackClearShop.TAG, "handleMessage msg = " + msg);
                TrackDBEvent dbEvent = null;
                if (msg.obj instanceof TrackDBEvent) {
                    dbEvent = msg.obj;
                }
                if (dbEvent != null) {
                    C1260i.b(TrackClearShop.TAG, "dbEvent.type = " + dbEvent.type);
                    if (dbEvent.type == 12) {
                        C1260i.b(TrackClearShop.TAG, "dbEvent.status = " + dbEvent.status);
                    }
                }
            }
        }
    }

    public void clearTrack(String useId) {
        this.useId = useId;
        cleanTrackRecordsFromDb(useId);
    }

    private void cleanTrackRecordsFromDb(String useId) {
        Context context = C1157a.a();
        Intent intent = new Intent(context, DataService.class);
        intent.putExtra(DataService.EXTRA_HANDLER, DataCache.getInstance().addCache(this.mHandler));
        intent.putExtra("useid", useId);
        intent.setAction(Action.ACTION_CLEAR_TRACK_BY_BDUID.toString());
        context.startService(intent);
    }
}
