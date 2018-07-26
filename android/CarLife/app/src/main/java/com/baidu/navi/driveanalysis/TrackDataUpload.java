package com.baidu.navi.driveanalysis;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.core.C0936j;
import com.baidu.carlife.p077e.C1435a;
import com.baidu.navi.driveanalysis.DataService.DataUploadBinder;

public class TrackDataUpload {
    public static TrackDataUpload mInstance;
    private DataUploadBinder mBinder;
    private Context mContext = BaiduNaviApplication.getInstance().getApplicationContext();
    private MsgRomoteConfigSyncHandler mMsgRomoteConfigSyncHandler;
    private ServiceConnection mServiceConnection;

    /* renamed from: com.baidu.navi.driveanalysis.TrackDataUpload$1 */
    class C37741 implements ServiceConnection {
        C37741() {
        }

        public void onServiceDisconnected(ComponentName name) {
        }

        public void onServiceConnected(ComponentName name, IBinder service) {
            TrackDataUpload.this.mBinder = (DataUploadBinder) service;
            TrackDataUpload.this.mBinder.startUpload();
        }
    }

    private class MsgRomoteConfigSyncHandler extends C0936j {
        private MsgRomoteConfigSyncHandler() {
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 6001:
                    if (C1435a.a().i() == 1) {
                        TrackDataUpload.this.startTrackDataUpload();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public void careAbout() {
            addMsg(6001);
        }
    }

    public static TrackDataUpload getInstance() {
        if (mInstance == null) {
            mInstance = new TrackDataUpload();
        }
        return mInstance;
    }

    private TrackDataUpload() {
    }

    public void startTrackDataUpload() {
        if (C1435a.a().i() == 1) {
            init();
        }
    }

    public void stopTrackDataUpload() {
        if (this.mBinder != null) {
            this.mBinder.stopUpload();
            this.mContext.unbindService(this.mServiceConnection);
        }
    }

    private void init() {
        this.mServiceConnection = new C37741();
        this.mContext.bindService(new Intent(this.mContext, DataService.class), this.mServiceConnection, 1);
    }
}
