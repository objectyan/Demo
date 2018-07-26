package com.baidu.navisdk.comapi.offlinedata;

import com.baidu.navisdk.comapi.base.BNObserver;

public interface BNOfflineDataObserver extends BNObserver {
    public static final int EVENT_CHECK_DATA_NOT_MATCH = 277;
    public static final int EVENT_DELETE_FINISH = 269;
    public static final int EVENT_DOWNLOAD_APK_FAIL = 275;
    public static final int EVENT_DOWNLOAD_APK_NET_ERROR = 276;
    public static final int EVENT_DOWNLOAD_APK_PROGRESS = 273;
    public static final int EVENT_DOWNLOAD_APK_START = 272;
    public static final int EVENT_DOWNLOAD_APK_SUCCESS = 274;
    public static final int EVENT_DOWNLOAD_FINISH = 262;
    public static final int EVENT_DOWNLOAD_PROGRESS = 261;
    public static final int EVENT_DOWNLOAD_REQUEST_FAIL = 258;
    public static final int EVENT_DOWNLOAD_REQUEST_NET_ERROR = 259;
    public static final int EVENT_DOWNLOAD_REQUEST_SUCCESS = 257;
    public static final int EVENT_DOWNLOAD_START = 260;
    public static final int EVENT_DOWNLOAD_SUSPEND = 263;
    public static final int EVENT_DOWNLOAD_SUSPEND_ALL = 264;
    public static final int EVENT_ERROR_MD5 = 278;
    public static final int EVENT_ERROR_SD_ERROR = 270;
    public static final int EVENT_ERROR_SD_FULL = 271;
    public static final int EVENT_UPDATE_FINISH = 267;
    public static final int EVENT_UPDATE_MERGE_FAIL = 291;
    public static final int EVENT_UPDATE_MERGE_START = 288;
    public static final int EVENT_UPDATE_MERGE_SUCCESS = 290;
    public static final int EVENT_UPDATE_MERGE_WAIT = 289;
    public static final int EVENT_UPDATE_PROGRESS = 266;
    public static final int EVENT_UPDATE_START = 265;
    public static final int EVENT_UPDATE_SUSPEND = 268;
    public static final int TYPE_DOWNLOAD_INFOR = 2;
    public static final int TYPE_ERROR = 3;
    public static final int TYPE_UPDATE_LIST = 1;

    public static class DownloadArg {
        public String mName;
        public int mProgress;
        public String mUpdateDate;
        public int mUpdatePoiCount;
        public int mUpdateRouteCount;
    }
}
