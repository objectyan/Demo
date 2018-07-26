package com.baidu.navi.track.datashop;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.C1260i;
import com.baidu.navi.track.database.DataBaseConstants.TrackQueryType;
import com.baidu.navi.track.database.DataCache;
import com.baidu.navi.track.database.DataService;
import com.baidu.navi.track.database.DataService.Action;
import com.baidu.navi.track.model.CarNaviModel;
import com.baidu.navi.track.model.TrackDBEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrackMainListShop {
    public static final int DEFAULT_REQ_COUNT = 20;
    private static final String TAG = TrackMainListShop.class.getSimpleName();
    private List<Object> dataList;
    private List<Object> geoList = new ArrayList();
    private boolean isClean;
    private Handler mHandler = new C39711();
    private Handler requestHandler;
    private TrackQueryType trackListQueryType = TrackQueryType.CAR;
    private ArrayList<Object> updateList = new ArrayList();

    /* renamed from: com.baidu.navi.track.datashop.TrackMainListShop$1 */
    class C39711 extends Handler {
        C39711() {
        }

        public void handleMessage(Message msg) {
            C1260i.b(TrackMainListShop.TAG, "handleMessage msg = " + msg);
            if (msg.what == 1) {
                TrackDBEvent dbEvent = null;
                if (msg.obj instanceof TrackDBEvent) {
                    dbEvent = msg.obj;
                }
                if (dbEvent != null) {
                    C1260i.b(TrackMainListShop.TAG, dbEvent.toString());
                    if (dbEvent.type == 3) {
                        TrackMainListShop.this.dataList = dbEvent.list;
                        TrackMainListShop.this.trackListQueryType = dbEvent.queryType;
                        if (TrackMainListShop.this.isClean) {
                            if (TrackMainListShop.this.dataList != null) {
                                ArrayList<String> guidList = new ArrayList();
                                for (Object item : TrackMainListShop.this.dataList) {
                                    if (item instanceof CarNaviModel) {
                                        guidList.add(((CarNaviModel) item).getPBData().getGuid());
                                    }
                                }
                                new DeleteFileThread(guidList).start();
                            }
                            TrackMainListShop.this.isClean = false;
                        } else if (TrackMainListShop.this.dataList == null || TrackMainListShop.this.dataList.isEmpty()) {
                            TrackMainListShop.this.notifyTrackListOk(Collections.EMPTY_LIST);
                        } else {
                            TrackMainListShop.this.notifyTrackListOk(TrackMainListShop.this.dataList);
                        }
                    }
                }
            }
        }
    }

    public TrackMainListShop(Handler handler) {
        this.requestHandler = handler;
    }

    public void fetchTrackList(String bduid, int ctime, TrackQueryType type) {
        fetchTrackList(bduid, ctime, type, 20);
    }

    public void fetchTrackList(String bduid, int ctime, int reqCount, TrackQueryType type) {
        fetchTrackList(bduid, ctime, type, reqCount);
    }

    public void clearBeforSixMonthGPSFile(String bduid) {
        new TrackFileCleanThread().start();
        this.isClean = true;
        fetchTrackList(bduid, (int) ((System.currentTimeMillis() / 1000) - 15552000), 2000, TrackQueryType.CAR);
    }

    public void fetchTrackList(String bduid, int ctime, TrackQueryType type, int limit) {
        if (ctime < 1) {
            ctime = Integer.MAX_VALUE;
        }
        Context context = C1157a.a();
        Intent intent = new Intent(context, DataService.class);
        intent.putExtra(DataService.EXTRA_START_TIME, ctime);
        intent.putExtra(DataService.EXTRA_LIMIT, limit);
        if (bduid == null) {
            intent.putExtra(DataService.EXTRA_BDUID, "");
        } else {
            intent.putExtra(DataService.EXTRA_BDUID, bduid);
        }
        intent.putExtra(DataService.EXTRA_QUERY_TYPE, type.toString());
        intent.putExtra(DataService.EXTRA_HANDLER, DataCache.getInstance().addCache(this.mHandler));
        intent.setAction(Action.ACTION_READ_TRACK_AFTER_TIME.toString());
        context.startService(intent);
    }

    public void notifyTrackListOk(List<Object> trackList) {
        if (this.requestHandler != null) {
            TrackShopEvent shopEvent = new TrackShopEvent();
            shopEvent.type = 3;
            shopEvent.status = 0;
            shopEvent.list = trackList;
            shopEvent.trackQueryType = this.trackListQueryType;
            this.requestHandler.obtainMessage(1, shopEvent).sendToTarget();
        }
    }
}
