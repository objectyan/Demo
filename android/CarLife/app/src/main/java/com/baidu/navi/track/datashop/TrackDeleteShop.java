package com.baidu.navi.track.datashop;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.C1260i;
import com.baidu.navi.track.common.TrackConfig;
import com.baidu.navi.track.database.DataCache;
import com.baidu.navi.track.database.DataService;
import com.baidu.navi.track.database.DataService.Action;
import com.baidu.navi.track.model.BaseTrackModel;
import com.baidu.navi.track.model.CarNaviModel;
import com.baidu.navi.track.model.TrackDBEvent;
import com.baidu.navi.util.NaviAccountUtils;
import java.util.ArrayList;
import java.util.List;

public class TrackDeleteShop {
    private static final String TAG = TrackDeleteShop.class.getSimpleName();
    private String guid;
    private Handler mHandler = new C39701();
    private Object originalObject;
    private Handler requestHandler;

    /* renamed from: com.baidu.navi.track.datashop.TrackDeleteShop$1 */
    class C39701 extends Handler {
        C39701() {
        }

        public void handleMessage(Message msg) {
            if (msg.what == 3) {
                C1260i.b(TrackDeleteShop.TAG, "handleMessage msg = " + msg);
                TrackDBEvent dbEvent = null;
                if (msg.obj instanceof TrackDBEvent) {
                    dbEvent = msg.obj;
                }
                if (dbEvent != null) {
                    C1260i.b(TrackDeleteShop.TAG, "dbEvent.type = " + dbEvent.type);
                    if (dbEvent.type == 6) {
                        if (dbEvent.item != null && dbEvent.item.guid.equalsIgnoreCase(TrackDeleteShop.this.guid)) {
                            if (dbEvent.status == 1) {
                                TrackDeleteShop.this.notifyDeleteSuccess();
                            } else {
                                TrackDeleteShop.this.notifyDeleteErr(-2);
                            }
                        }
                        C1260i.b(TrackDeleteShop.TAG, "dbEvent.status = " + dbEvent.status);
                    }
                }
            }
        }
    }

    public TrackDeleteShop(Handler handler) {
        this.requestHandler = handler;
    }

    public void deleteTrackRecord(Object trackItem) {
        if (trackItem != null) {
            BaseTrackModel model = preDeleteTrackRecord(trackItem);
            if (model != null && !TextUtils.isEmpty(model.guid)) {
                this.guid = model.guid;
                if (!NaviAccountUtils.getInstance().isLogin()) {
                    deleteRecordFromLocal(model.guid);
                } else if (TextUtils.isEmpty(model.sid)) {
                    deleteRecordFromLocal(model.guid);
                } else {
                    deleteRecordAndMarkChange(model);
                }
            }
        }
    }

    private void deleteRecordAndMarkChange(BaseTrackModel model) {
        Context context = C1157a.a();
        Intent intent = new Intent(context, DataService.class);
        intent.setAction(Action.ACTION_UPDATE_TRACK_BY_GUID.toString());
        intent.putExtra(DataService.EXTRA_CACHE_KEY, DataCache.getInstance().addCache(model));
        context.startService(intent);
    }

    private void deleteRecordFromLocal(String guid) {
        Context context = C1157a.a();
        Intent intent = new Intent(context, DataService.class);
        intent.putExtra(DataService.EXTRA_HANDLER, DataCache.getInstance().addCache(this.mHandler));
        intent.putExtra("guid", guid);
        intent.setAction(Action.ACTION_DELETE_TRACK_BY_GUID.toString());
        context.startService(intent);
        List<String> guids = new ArrayList();
        guids.add(guid);
        new DeleteFileThread(guids).start();
    }

    private BaseTrackModel preDeleteTrackRecord(Object oriObject) {
        BaseTrackModel model = new BaseTrackModel();
        if (!(oriObject instanceof CarNaviModel)) {
            return model;
        }
        CarNaviModel carNaviModel = (CarNaviModel) oriObject;
        if (carNaviModel.getPBData() == null) {
            return null;
        }
        model.sid = carNaviModel.getPBData().getSid();
        model.guid = carNaviModel.getPBData().getGuid();
        model.useId = carNaviModel.getUseId();
        model.ctime = carNaviModel.getPBData().getCtime();
        model.modifyTime = (int) (System.currentTimeMillis() / 1000);
        model.type = carNaviModel.getPBData().getType();
        model.syncState = 2;
        this.originalObject = carNaviModel.clone();
        ((CarNaviModel) this.originalObject).setSyncState(2);
        int totalDistanse = TrackConfig.getInstance().getTotalDistanse();
        int weekEndTime = TrackConfig.getInstance().getWeekEndTime();
        if (weekEndTime == 0 || totalDistanse == 0) {
            return model;
        }
        int weekStartTime = weekEndTime - 604800;
        int weekDistanse = TrackConfig.getInstance().getWeekDistanse();
        int distanse = ((CarNaviModel) this.originalObject).getPBData().getDistance();
        int maxTime = TrackConfig.getInstance().getMaxTime();
        if (totalDistanse > 0 && maxTime > 0 && carNaviModel.getPBData().getDuration() == maxTime) {
            TrackConfig.getInstance().setMaxTime(0);
        }
        if (weekDistanse >= distanse && model.ctime >= weekStartTime && model.ctime < weekEndTime) {
            TrackConfig.getInstance().setWeekDistanse(weekDistanse - distanse);
        }
        if (totalDistanse < distanse) {
            return model;
        }
        TrackConfig.getInstance().setTotalDistanse(totalDistanse - distanse);
        return model;
    }

    private void notifyDeleteSuccess() {
        if (this.requestHandler != null) {
            BaseTrackModel model = new BaseTrackModel();
            model.guid = this.guid;
            TrackShopEvent shopEvent = new TrackShopEvent();
            shopEvent.type = 6;
            shopEvent.status = 0;
            shopEvent.item = model;
            this.requestHandler.obtainMessage(3, shopEvent).sendToTarget();
        }
    }

    private void notifyDeleteErr(int status) {
        if (this.requestHandler != null) {
            BaseTrackModel model = new BaseTrackModel();
            model.guid = this.guid;
            TrackShopEvent shopEvent = new TrackShopEvent();
            shopEvent.type = 6;
            shopEvent.status = status;
            shopEvent.item = model;
            this.requestHandler.obtainMessage(3, shopEvent).sendToTarget();
        }
    }
}
