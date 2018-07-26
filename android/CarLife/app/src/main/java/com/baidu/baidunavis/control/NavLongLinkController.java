package com.baidu.baidunavis.control;

import android.os.Bundle;
import com.baidu.baidunavis.wrapper.LogUtil;
import com.baidu.platform.comapi.longlink.ELongLinkStatus;
import com.baidu.platform.comapi.longlink.LongLinkClient;
import com.baidu.platform.comapi.longlink.LongLinkDataCallback;
import com.baidu.platform.comapi.longlink.LongLinkFileData;
import com.baidu.platform.comapi.p207a.C4755b;
import java.util.ArrayList;
import java.util.Arrays;

public class NavLongLinkController {
    public static final int FellowModuleId = 10;
    public static final int FellowModuleId_for_test_cpu = 11;
    public static final String TAG = NavLongLinkController.class.getSimpleName();
    private static NavLongLinkController sInstance = null;
    private LongLinkClient mLongLinkClient;
    private LongLinkDataCallback mLongLinkDataCallback;

    /* renamed from: com.baidu.baidunavis.control.NavLongLinkController$1 */
    class C08031 implements LongLinkDataCallback {
        C08031() {
        }

        public boolean onReceiveData(ELongLinkStatus status, int reqId, byte[] dataBuffer, boolean isPush) {
            LogUtil.m3004e("onFellowCreateLCS", "onReceiveData:reqId:" + reqId + " status:" + status + " data: " + new String(dataBuffer) + "  isPush: " + isPush);
            return true;
        }
    }

    private NavLongLinkController() {
    }

    public static NavLongLinkController getInstance() {
        if (sInstance == null) {
            sInstance = new NavLongLinkController();
        }
        return sInstance;
    }

    public boolean createLCS() {
        try {
            if (this.mLongLinkClient == null) {
                this.mLongLinkClient = LongLinkClient.create(10);
            }
            return true;
        } catch (Exception e) {
            LogUtil.m3004e("onFellowCloseLCS", "createLCS Exception   e====");
            e.printStackTrace();
            return false;
        }
    }

    public boolean registerLCS() {
        try {
            if (this.mLongLinkClient != null) {
                if (this.mLongLinkDataCallback == null) {
                    this.mLongLinkDataCallback = new C08031();
                }
                return this.mLongLinkClient.register(this.mLongLinkDataCallback);
            }
        } catch (C4755b e) {
            LogUtil.m3004e("onFellowregisterLCS", "registerLCS Exception   e====");
            e.printStackTrace();
        }
        return false;
    }

    public boolean unRegisterLCS() {
        if (this.mLongLinkClient != null) {
            try {
                boolean ret = this.mLongLinkClient.unRegister(this.mLongLinkDataCallback);
                this.mLongLinkDataCallback = null;
                return ret;
            } catch (C4755b e) {
                this.mLongLinkDataCallback = null;
                LogUtil.m3004e("onFellowUnregisterLCS", "unRegisterLCS Exception   e====");
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean CloseLCS() {
        if (this.mLongLinkClient != null) {
            try {
                boolean ret = this.mLongLinkClient.release() != -1;
                this.mLongLinkClient = null;
                return ret;
            } catch (Exception e) {
                this.mLongLinkClient = null;
                LogUtil.m3004e("onFellowCloseLCS", "CloseLCS Exception   e====");
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean IsLCSConnect() {
        if (this.mLongLinkClient != null) {
            try {
                return this.mLongLinkClient.isValid();
            } catch (Exception e) {
            }
        }
        return false;
    }

    public Bundle SendData(int reqId, byte[] data, String queryStr, String fileName) {
        if (this.mLongLinkClient != null) {
            try {
                ArrayList<LongLinkFileData> dataList = new ArrayList();
                LongLinkFileData fileData = new LongLinkFileData();
                fileData.fileName = fileName;
                fileData.binData = Arrays.copyOf(data, data.length);
                dataList.add(fileData);
                ELongLinkStatus ret = this.mLongLinkClient.sendFileData(queryStr, dataList);
                Bundle bd = new Bundle();
                if (ret == null) {
                    return bd;
                }
                bd.putInt("StatusCode", ret.getStatusCode());
                bd.putInt("RequestId", ret.getRequestId());
                return bd;
            } catch (Exception e) {
            }
        }
        return null;
    }

    public int GetReqId() {
        if (this.mLongLinkClient != null) {
            return this.mLongLinkClient.getRequestId();
        }
        return -1;
    }
}
