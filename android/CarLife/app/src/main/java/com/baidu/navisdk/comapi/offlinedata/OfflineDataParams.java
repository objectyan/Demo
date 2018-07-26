package com.baidu.navisdk.comapi.offlinedata;

import com.baidu.navisdk.comapi.routeplan.RoutePlanParams;

public class OfflineDataParams {
    public static final String[] PROVINCE_NAME = new String[]{RoutePlanParams.COUNTRY_OFFLINE_DATA, "北京", "天津", "河北", "山西", "内蒙古", "辽宁", "吉林", "黑龙江", "上海", "江苏", "浙江", "安徽", "福建", "江西", "山东", "河南", "湖北", "湖南", "广东", "广西", "海南", "重庆", "四川", "贵州", "云南", "西藏", "陕西", "甘肃", "青海", "宁夏", "新疆", "香港", "澳门"};

    public class Const {
        public static final int COLOR_BLACK = -1;
        public static final int COLOR_BLUE = -14375169;
        public static final int COLOR_GRAY = -9866377;
        public static final int COLOR_GREEN = -7879352;
        public static final int COLOR_ORANGE = -1658089;
        public static final int NE_DM_SUSPEND_ALL_ID = -1;
    }

    public class EngineDataStatus {
        public static final int NE_DM_STATUS_ALL = 5;
        public static final int NE_DM_STATUS_DOWNLOADED = 2;
        public static final int NE_DM_STATUS_DOWNLOADING = 1;
        public static final int NE_DM_STATUS_NEED_UPDATE = 3;
        public static final int NE_DM_STATUS_UNDOWNLOAD = 0;
        public static final int NE_DM_STATUS_UPDATING = 4;
    }

    public class FileScanStutus {
        public static final int FILE_SACN_ALL_NOT_MATCH = 5;
        public static final int FILE_SACN_DATA_APP_MATCH = 2;
        public static final int FILE_SACN_DATA_MATCH_APK_NOTMATCH = 3;
        public static final int FILE_SACN_DATA_NOTMATCH_APK_MATCH = 4;
        public static final int FILE_SACN_INVALID = 0;
        public static final int FILE_SACN_NO_DATA = 1;
    }

    public class Key {
        public static final String DOWNLOAD_KEY_PROVINCE_ID = "KEY_PROVINCE_ID";
        public static final String PREF_KEY_NAVI_AUTO_CHECK_NEW_DATA = "PREF_KEY_NAVI_AUTO_CHECK_NEW_DATA";
    }

    public class ProvinceId {
        public static final int NE_DM_COMMON_ID = 0;
        public static final int NE_DM_MAX_PROVINCE_ID = 33;
        public static final int NE_DM_MIN_PROVINCE_ID = 1;
    }

    public class UiStatus {
        public static final int UI_STATUS_DOWNLOADING = 2;
        public static final int UI_STATUS_FINISHED = 5;
        public static final int UI_STATUS_NEED_UPDATE = 10;
        public static final int UI_STATUS_NET_ERROR = 6;
        public static final int UI_STATUS_SDCARD_ERROR = 9;
        public static final int UI_STATUS_SUSPEND = 4;
        public static final int UI_STATUS_SUSPENDED_UPDATE = 13;
        public static final int UI_STATUS_UNDOWNLOAD = 1;
        public static final int UI_STATUS_UPDATE_FINISHED = 14;
        public static final int UI_STATUS_UPDATE_MERGE_FAIL = 19;
        public static final int UI_STATUS_UPDATE_MERGE_START = 16;
        public static final int UI_STATUS_UPDATE_MERGE_SUCCESS = 18;
        public static final int UI_STATUS_UPDATE_MERGE_WAIT = 17;
        public static final int UI_STATUS_UPDATE_RESTART = 15;
        public static final int UI_STATUS_UPDATING = 12;
        public static final int UI_STATUS_WAITE_UPDATE = 11;
        public static final int UI_STATUS_WAITING = 3;
        public static final int UI_STATUS_WIFI_ERROR = 8;
    }
}
